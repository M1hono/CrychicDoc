package com.almostreliable.summoningrituals;

import com.almostreliable.summoningrituals.network.PacketHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod("summoningrituals")
public class SummoningRituals {

    public SummoningRituals() {
        this.onInitialize();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> {
            SummoningRitualsClient client = new SummoningRitualsClient();
            return client::onInitializeClient;
        });
    }

    public void onInitialize() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(SummoningRituals::onCommonSetup);
        modEventBus.addListener(SummoningRituals::onRegistryEvent);
        modEventBus.addListener(SummoningRituals::onCreativeTabContents);
        Registration.init(modEventBus);
    }

    private static void onCommonSetup(FMLCommonSetupEvent event) {
        PacketHandler.init();
    }

    private static void onRegistryEvent(RegisterEvent event) {
        Registration.Tab.registerTab(event);
    }

    private static void onCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        Registration.Tab.initContents(event);
    }
}