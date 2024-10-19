package net.permutated.pylons.machines.harvester;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;
import net.permutated.pylons.ModRegistry;
import net.permutated.pylons.machines.base.AbstractPylonContainer;

import java.util.function.Supplier;

public class HarvesterPylonContainer extends AbstractPylonContainer {
    private final HarvesterPylonTile.Status workStatus;
    public HarvesterPylonContainer(int windowId, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
        super(ModRegistry.HARVESTER_PYLON_CONTAINER.get(), windowId, playerInventory, packetBuffer, HarvesterPylonTile.requiresPower());
        workStatus = packetBuffer.readEnum(HarvesterPylonTile.Status.class);
    }

    @Override
    protected Supplier<Block> getBlock() {
        return ModRegistry.HARVESTER_PYLON;
    }

    @Override
    public boolean shouldRenderRange() {
        return true;
    }

    public HarvesterPylonTile.Status getWorkStatus() {
        return workStatus;
    }
}
