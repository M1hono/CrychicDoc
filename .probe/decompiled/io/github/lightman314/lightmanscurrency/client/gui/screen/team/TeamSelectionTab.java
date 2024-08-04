package io.github.lightman314.lightmanscurrency.client.gui.screen.team;

import io.github.lightman314.lightmanscurrency.LCText;
import io.github.lightman314.lightmanscurrency.api.misc.client.rendering.EasyGuiGraphics;
import io.github.lightman314.lightmanscurrency.client.gui.screen.TeamManagerScreen;
import io.github.lightman314.lightmanscurrency.client.gui.widget.TeamSelectWidget;
import io.github.lightman314.lightmanscurrency.client.gui.widget.button.icon.IconData;
import io.github.lightman314.lightmanscurrency.client.gui.widget.easy.EasyButton;
import io.github.lightman314.lightmanscurrency.client.gui.widget.easy.EasyTextButton;
import io.github.lightman314.lightmanscurrency.client.util.ScreenArea;
import io.github.lightman314.lightmanscurrency.common.teams.Team;
import io.github.lightman314.lightmanscurrency.common.teams.TeamSaveData;
import io.github.lightman314.lightmanscurrency.network.message.teams.CPacketCreateTeam;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class TeamSelectionTab extends TeamTab {

    TeamSelectWidget teamSelection;

    List<Team> teamList = new ArrayList();

    EditBox newTeamName;

    EasyButton buttonCreateTeam;

    public TeamSelectionTab(TeamManagerScreen screen) {
        super(screen);
    }

    @Nonnull
    @NotNull
    @Override
    public IconData getIcon() {
        return IconData.of(Items.PAPER);
    }

    public MutableComponent getTooltip() {
        return LCText.TOOLTIP_TEAM_SELECT.get();
    }

    @Override
    public boolean allowViewing(Player player, Team team) {
        return true;
    }

    @Override
    public boolean blockInventoryClosing() {
        return true;
    }

    @Override
    public void initialize(ScreenArea screenArea, boolean firstOpen) {
        this.refreshTeamList();
        this.teamSelection = this.addChild(new TeamSelectWidget(screenArea.pos.offset(10, 20), 5, () -> this.teamList, this::getActiveTeam, this::selectTeamButton));
        this.newTeamName = this.addChild(new EditBox(this.getFont(), screenArea.x + 20, screenArea.y + 140, 160, 20, Component.empty()));
        this.newTeamName.setMaxLength(32);
        this.buttonCreateTeam = this.addChild(new EasyTextButton(screenArea.pos.offset(120, 165), 60, 20, LCText.BUTTON_TEAM_CREATE.get(), this::createTeam));
        this.buttonCreateTeam.f_93623_ = false;
    }

    private Team getTeam(int teamIndex) {
        return teamIndex < this.teamList.size() ? (Team) this.teamList.get(teamIndex) : null;
    }

    private void refreshTeamList() {
        this.teamList = new ArrayList();
        List<Team> allTeams = TeamSaveData.GetAllTeams(true);
        allTeams.forEach(team -> {
            if (team.isMember(this.getPlayer())) {
                this.teamList.add(team);
            }
        });
        this.teamList.sort(Team.sorterFor(this.getPlayer()));
    }

    @Override
    public void renderBG(@Nonnull EasyGuiGraphics gui) {
        gui.drawString(LCText.GUI_TEAM_SELECT.get(), 20, 10, 4210752);
        gui.drawString(LCText.GUI_TEAM_CREATE.get(), 20, 130, 4210752);
    }

    @Override
    public void tick() {
        this.refreshTeamList();
        this.buttonCreateTeam.f_93623_ = !this.newTeamName.getValue().isBlank();
    }

    private void selectTeamButton(int teamIndex) {
        Team team = this.getTeam(teamIndex);
        if (team != null) {
            if (this.screen.getActiveTeam() == team) {
                this.screen.setActiveTeam(-1L);
            } else {
                this.screen.setActiveTeam(team.getID());
            }
        }
    }

    private void createTeam(EasyButton button) {
        if (!this.newTeamName.getValue().isEmpty()) {
            new CPacketCreateTeam(this.newTeamName.getValue()).send();
            this.newTeamName.setValue("");
        }
    }
}