package net.minecraft;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.logging.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import net.minecraft.server.packs.PackType;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.DataVersion;
import org.slf4j.Logger;

public class DetectedVersion implements WorldVersion {

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final WorldVersion BUILT_IN = new DetectedVersion();

    private final String id;

    private final String name;

    private final boolean stable;

    private final DataVersion worldVersion;

    private final int protocolVersion;

    private final int resourcePackVersion;

    private final int dataPackVersion;

    private final Date buildTime;

    private DetectedVersion() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = "1.20.1";
        this.stable = true;
        this.worldVersion = new DataVersion(3465, "main");
        this.protocolVersion = SharedConstants.getProtocolVersion();
        this.resourcePackVersion = 15;
        this.dataPackVersion = 15;
        this.buildTime = new Date();
    }

    private DetectedVersion(JsonObject jsonObject0) {
        this.id = GsonHelper.getAsString(jsonObject0, "id");
        this.name = GsonHelper.getAsString(jsonObject0, "name");
        this.stable = GsonHelper.getAsBoolean(jsonObject0, "stable");
        this.worldVersion = new DataVersion(GsonHelper.getAsInt(jsonObject0, "world_version"), GsonHelper.getAsString(jsonObject0, "series_id", DataVersion.MAIN_SERIES));
        this.protocolVersion = GsonHelper.getAsInt(jsonObject0, "protocol_version");
        JsonObject $$1 = GsonHelper.getAsJsonObject(jsonObject0, "pack_version");
        this.resourcePackVersion = GsonHelper.getAsInt($$1, "resource");
        this.dataPackVersion = GsonHelper.getAsInt($$1, "data");
        this.buildTime = Date.from(ZonedDateTime.parse(GsonHelper.getAsString(jsonObject0, "build_time")).toInstant());
    }

    public static WorldVersion tryDetectVersion() {
        try {
            InputStream $$0 = DetectedVersion.class.getResourceAsStream("/version.json");
            WorldVersion var9;
            label63: {
                DetectedVersion var2;
                try {
                    if ($$0 == null) {
                        LOGGER.warn("Missing version information!");
                        var9 = BUILT_IN;
                        break label63;
                    }
                    InputStreamReader $$1 = new InputStreamReader($$0);
                    try {
                        var2 = new DetectedVersion(GsonHelper.parse($$1));
                    } catch (Throwable var6) {
                        try {
                            $$1.close();
                        } catch (Throwable var5) {
                            var6.addSuppressed(var5);
                        }
                        throw var6;
                    }
                    $$1.close();
                } catch (Throwable var7) {
                    if ($$0 != null) {
                        try {
                            $$0.close();
                        } catch (Throwable var4) {
                            var7.addSuppressed(var4);
                        }
                    }
                    throw var7;
                }
                if ($$0 != null) {
                    $$0.close();
                }
                return var2;
            }
            if ($$0 != null) {
                $$0.close();
            }
            return var9;
        } catch (JsonParseException | IOException var8) {
            throw new IllegalStateException("Game version information is corrupt", var8);
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DataVersion getDataVersion() {
        return this.worldVersion;
    }

    @Override
    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public int getPackVersion(PackType packType0) {
        return packType0 == PackType.SERVER_DATA ? this.dataPackVersion : this.resourcePackVersion;
    }

    @Override
    public Date getBuildTime() {
        return this.buildTime;
    }

    @Override
    public boolean isStable() {
        return this.stable;
    }
}