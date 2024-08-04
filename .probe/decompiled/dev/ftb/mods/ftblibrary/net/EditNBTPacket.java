package dev.ftb.mods.ftblibrary.net;

import dev.architectury.networking.NetworkManager;
import dev.architectury.networking.simple.BaseS2CMessage;
import dev.architectury.networking.simple.MessageType;
import dev.ftb.mods.ftblibrary.FTBLibrary;
import dev.ftb.mods.ftblibrary.nbtedit.NBTEditorScreen;
import dev.ftb.mods.ftblibrary.util.NBTUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;

public class EditNBTPacket extends BaseS2CMessage {

    private final CompoundTag info;

    private final CompoundTag tag;

    public EditNBTPacket(FriendlyByteBuf buf) {
        this.info = buf.readNbt();
        this.tag = buf.readAnySizeNbt();
    }

    public EditNBTPacket(CompoundTag i, CompoundTag t) {
        this.info = i;
        this.tag = t;
    }

    @Override
    public MessageType getType() {
        return FTBLibraryNet.EDIT_NBT;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeNbt(this.info);
        buf.writeNbt(this.tag);
    }

    @Override
    public void handle(NetworkManager.PacketContext context) {
        new NBTEditorScreen(this.info, this.tag, (accepted, tag) -> {
            if (accepted) {
                if (NBTUtils.getSizeInBytes(tag, false) >= 30000L) {
                    FTBLibrary.LOGGER.error("NBT too large to send!");
                } else {
                    new EditNBTResponsePacket(this.info, tag).sendToServer();
                }
            }
        }).openGui();
    }
}