package fr.lucreeper74.createmetallurgy.content.light_bulb.network;

import net.minecraft.core.BlockPos;

public interface INetworkNode {

    int getTransmittedSignal();

    void setReceivedSignal(int var1);

    boolean isAlive();

    BlockPos getLocation();

    NetworkHandler.Address getAddress();
}