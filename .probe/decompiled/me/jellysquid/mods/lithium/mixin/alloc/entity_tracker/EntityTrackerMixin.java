package me.jellysquid.mods.lithium.mixin.alloc.entity_tracker;

import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import java.util.Set;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.network.ServerPlayerConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ ChunkMap.TrackedEntity.class })
public class EntityTrackerMixin {

    @Redirect(method = { "<init>" }, require = 0, at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Sets;newIdentityHashSet()Ljava/util/Set;", remap = false))
    private Set<ServerPlayerConnection> useFasterCollection() {
        return new ReferenceOpenHashSet();
    }
}