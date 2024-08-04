package fabric.me.thosea.badoptimizations.other;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.injectables.annotations.ExpectPlatform.Transformed;
import fabric.me.thosea.badoptimizations.other.fabric.PlatformMethodsImpl;
import java.io.File;

public final class PlatformMethods {

    private PlatformMethods() {
    }

    @ExpectPlatform
    @Transformed
    public static String getVersion() {
        return PlatformMethodsImpl.getVersion();
    }

    @ExpectPlatform
    @Transformed
    public static File getConfigFolder() {
        return PlatformMethodsImpl.getConfigFolder();
    }

    @ExpectPlatform
    @Transformed
    public static boolean isModLoaded(String id) {
        return PlatformMethodsImpl.isModLoaded(id);
    }
}