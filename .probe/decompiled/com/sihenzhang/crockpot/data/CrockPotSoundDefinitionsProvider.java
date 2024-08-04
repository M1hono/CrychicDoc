package com.sihenzhang.crockpot.data;

import com.sihenzhang.crockpot.base.CrockPotSoundEvents;
import com.sihenzhang.crockpot.util.RLUtils;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class CrockPotSoundDefinitionsProvider extends SoundDefinitionsProvider {

    protected CrockPotSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, "crockpot", helper);
    }

    @Override
    public void registerSounds() {
        this.add(CrockPotSoundEvents.CROCK_POT_CLOSE.get(), definition().subtitle(getSubtitleName("block.crock_pot.close")).with(sound(RLUtils.createRL("crock_pot_close"))));
        this.add(CrockPotSoundEvents.CROCK_POT_OPEN.get(), definition().subtitle(getSubtitleName("block.crock_pot.open")).with(sound(RLUtils.createRL("crock_pot_open"))));
        this.add(CrockPotSoundEvents.CROCK_POT_FINISH.get(), definition().subtitle(getSubtitleName("block.crock_pot.finish")).with(sound(RLUtils.createRL("crock_pot_finish"))));
        this.add(CrockPotSoundEvents.CROCK_POT_RATTLE.get(), definition().subtitle(getSubtitleName("block.crock_pot.rattle")).with(sound(RLUtils.createRL("crock_pot_rattle_1")), sound(RLUtils.createRL("crock_pot_rattle_2")), sound(RLUtils.createRL("crock_pot_rattle_3")), sound(RLUtils.createRL("crock_pot_rattle_4")), sound(RLUtils.createRL("crock_pot_rattle_5")), sound(RLUtils.createRL("crock_pot_rattle_6")), sound(RLUtils.createRL("crock_pot_rattle_7"))));
    }

    public static String getSubtitleName(String name) {
        return "subtitles.crockpot." + name;
    }
}