package de.keksuccino.fancymenu.util.rendering.ui.screen.filebrowser;

import de.keksuccino.fancymenu.util.LocalizationUtils;
import de.keksuccino.fancymenu.util.file.FileFilter;
import de.keksuccino.fancymenu.util.input.CharacterFilter;
import de.keksuccino.fancymenu.util.rendering.ui.UIBase;
import de.keksuccino.fancymenu.util.rendering.ui.screen.ConfirmationScreen;
import de.keksuccino.fancymenu.util.rendering.ui.scroll.v1.scrollarea.ScrollArea;
import de.keksuccino.fancymenu.util.rendering.ui.scroll.v1.scrollarea.entry.ScrollAreaEntry;
import de.keksuccino.fancymenu.util.rendering.ui.widget.button.ExtendedButton;
import de.keksuccino.fancymenu.util.rendering.ui.widget.editbox.ExtendedEditBox;
import java.io.File;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SaveFileScreen extends AbstractFileBrowserScreen {

    protected static final Component FILE_NAME_PREFIX_TEXT = Component.translatable("fancymenu.file_browser.save_file.file_name");

    @Nullable
    protected String forcedFileExtension;

    protected String defaultFileName;

    protected boolean forceResourceFriendlyFileNames = true;

    protected ExtendedEditBox fileNameEditBox;

    @NotNull
    public static SaveFileScreen build(@NotNull File rootDirectory, @Nullable String fileNamePreset, @Nullable String forcedFileExtension, @NotNull Consumer<File> callback) {
        return new SaveFileScreen(rootDirectory, rootDirectory, fileNamePreset, forcedFileExtension, callback);
    }

    public SaveFileScreen(@Nullable File rootDirectory, @NotNull File startDirectory, @Nullable String fileNamePreset, @Nullable String forcedFileExtension, @NotNull Consumer<File> callback) {
        super(Component.translatable("fancymenu.ui.save_file"), rootDirectory, startDirectory, callback);
        this.forcedFileExtension = forcedFileExtension;
        if (this.forcedFileExtension != null) {
            if (this.forcedFileExtension.startsWith(".")) {
                this.forcedFileExtension = this.forcedFileExtension.substring(1);
            }
            this.fileFilter = file -> file.getName().toLowerCase().endsWith("." + this.forcedFileExtension.toLowerCase());
        }
        this.fileNameEditBox = new ExtendedEditBox(Minecraft.getInstance().font, 0, 0, 150, 18, Component.translatable("fancymenu.ui.save_file.file_name"));
        if (this.forcedFileExtension != null) {
            this.fileNameEditBox.setInputSuffix("." + this.forcedFileExtension.toLowerCase());
            this.fileNameEditBox.applyInputPrefixSuffixCharacterRenderFormatter();
        }
        this.fileNameEditBox.m_94199_(10000);
        UIBase.applyDefaultWidgetSkinTo(this.fileNameEditBox);
        String editBoxPresetValue = "new_file";
        if (fileNamePreset != null) {
            if (this.forcedFileExtension != null && fileNamePreset.toLowerCase().endsWith("." + this.forcedFileExtension.toLowerCase())) {
                fileNamePreset = fileNamePreset.substring(0, Math.max(1, fileNamePreset.length() - (this.forcedFileExtension.length() + 1)));
            }
            editBoxPresetValue = fileNamePreset;
        }
        if (this.forcedFileExtension != null) {
            editBoxPresetValue = editBoxPresetValue + "." + this.forcedFileExtension;
        }
        this.fileNameEditBox.setValue(editBoxPresetValue);
        this.fileNameEditBox.m_94196_(0);
        this.fileNameEditBox.m_94208_(0);
        this.fileNameEditBox.setDisplayPosition(0);
        this.defaultFileName = editBoxPresetValue;
        this.setForceResourceFriendlyFileNames(true);
        this.fileScrollListHeightOffset = -25;
        this.fileTypeScrollListYOffset = 25;
    }

    @Override
    protected void init() {
        this.m_7787_(this.fileNameEditBox);
        super.init();
    }

    @Override
    public void tick() {
        this.fileNameEditBox.m_94120_();
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partial) {
        if (this.forcedFileExtension != null && !this.fileNameEditBox.m_94155_().toLowerCase().endsWith("." + this.forcedFileExtension.toLowerCase())) {
            this.fileNameEditBox.setValue(this.defaultFileName);
        }
        super.render(graphics, mouseX, mouseY, partial);
        this.renderFileNameEditBox(graphics, mouseX, mouseY, partial);
    }

    protected void renderFileNameEditBox(GuiGraphics graphics, int mouseX, int mouseY, float partial) {
        this.fileNameEditBox.m_93674_(this.getBelowFileScrollAreaElementWidth() - 2);
        this.fileNameEditBox.m_252865_(this.fileListScrollArea.getXWithBorder() + this.fileListScrollArea.getWidthWithBorder() - this.fileNameEditBox.m_5711_() - 1);
        this.fileNameEditBox.m_253211_(this.fileListScrollArea.getYWithBorder() + this.fileListScrollArea.getHeightWithBorder() + 5 + 1);
        this.fileNameEditBox.m_88315_(graphics, mouseX, mouseY, partial);
        graphics.drawString(this.f_96547_, FILE_NAME_PREFIX_TEXT, this.fileNameEditBox.m_252754_() - 1 - Minecraft.getInstance().font.width(FILE_NAME_PREFIX_TEXT) - 5, this.fileNameEditBox.m_252907_() - 1 + this.fileNameEditBox.m_93694_() / 2 - 9 / 2, UIBase.getUIColorTheme().element_label_color_normal.getColorInt(), false);
    }

    @Override
    protected int getBelowFileScrollAreaElementWidth() {
        int w = this.fileListScrollArea.getWidthWithBorder() - Minecraft.getInstance().font.width(FILE_NAME_PREFIX_TEXT) - 5;
        return Math.min(super.getBelowFileScrollAreaElementWidth(), w);
    }

    @NotNull
    @Override
    protected ExtendedButton buildConfirmButton() {
        return new ExtendedButton(0, 0, 150, 20, Component.translatable("fancymenu.ui.save_file.save"), button -> this.trySave()) {

            @Override
            public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partial) {
                AbstractFileBrowserScreen.AbstractFileScrollAreaEntry selected = SaveFileScreen.this.getSelectedEntry();
                this.f_93623_ = SaveFileScreen.this.canSave();
                super.render(graphics, mouseX, mouseY, partial);
            }
        };
    }

    @Override
    public AbstractFileBrowserScreen setFileFilter(@Nullable FileFilter fileFilter) {
        if (this.forcedFileExtension == null) {
            return super.setFileFilter(fileFilter);
        } else {
            LOGGER.error("[FANCYMENU] Can't set file filter for SaveFileScreen with forced file extension!");
            return this;
        }
    }

    @Override
    protected boolean isWidgetHovered() {
        return this.fileNameEditBox.m_198029_() ? false : super.isWidgetHovered();
    }

    @Nullable
    public CharacterFilter getFileNameCharacterFilter() {
        return this.fileNameEditBox.getCharacterFilter();
    }

    public SaveFileScreen setFileNameCharacterFilter(@Nullable CharacterFilter characterFilter) {
        if (this.forceResourceFriendlyFileNames) {
            LOGGER.error("[FANCYMENU] Unable to set file name character filter for SaveFileScreen while 'forceResourceFriendlyFileNames' is enabled!");
            return this;
        } else {
            this.fileNameEditBox.setCharacterFilter(characterFilter);
            return this;
        }
    }

    public SaveFileScreen setFileName(@NotNull String fileName) {
        this.fileNameEditBox.setValue(fileName);
        return this;
    }

    public boolean forceResourceFriendlyFileNames() {
        return this.forceResourceFriendlyFileNames;
    }

    public SaveFileScreen setForceResourceFriendlyFileNames(boolean forceResourceFriendlyFileNames) {
        this.forceResourceFriendlyFileNames = forceResourceFriendlyFileNames;
        if (!this.forceResourceFriendlyFileNames) {
            this.fileNameEditBox.setCharacterFilter(null);
        } else {
            this.fileNameEditBox.setCharacterFilter(CharacterFilter.buildOnlyLowercaseFileNameFilter());
        }
        return this;
    }

    protected void trySave() {
        File f = this.getSaveFile();
        if (f != null) {
            if (!f.isFile()) {
                this.callback.accept(new File(f.getPath().replace("\\", "/")));
            } else {
                Minecraft.getInstance().setScreen(ConfirmationScreen.warning(call -> {
                    Minecraft.getInstance().setScreen(this);
                    if (call) {
                        try {
                            this.callback.accept(new File(f.getPath().replace("\\", "/")));
                        } catch (Exception var4) {
                            var4.printStackTrace();
                        }
                    }
                }, LocalizationUtils.splitLocalizedLines("fancymenu.ui.save_file.save.override_warning")));
            }
        }
    }

    protected boolean canSave() {
        return this.getSaveFile() != null;
    }

    @Nullable
    protected File getSaveFile() {
        AbstractFileBrowserScreen.AbstractFileScrollAreaEntry e = this.getSelectedEntry();
        if (e != null && e.file.isDirectory()) {
            return null;
        } else if (!this.fileNameEditBox.m_94155_().replace(" ", "").isEmpty()) {
            File f = new File(this.currentDir, "/" + this.fileNameEditBox.m_94155_());
            return !this.shouldShowFile(f) ? null : f;
        } else {
            return null;
        }
    }

    @Override
    protected AbstractFileBrowserScreen.AbstractFileScrollAreaEntry buildFileEntry(@NotNull File f) {
        return new SaveFileScreen.SaveFileScrollAreaEntry(this.fileListScrollArea, f);
    }

    @Override
    public boolean keyPressed(int keycode, int scancode, int modifiers) {
        if (keycode == 257) {
            this.trySave();
            return true;
        } else {
            return super.m_7933_(keycode, scancode, modifiers);
        }
    }

    public class SaveFileScrollAreaEntry extends AbstractFileBrowserScreen.AbstractFileScrollAreaEntry {

        public SaveFileScrollAreaEntry(@NotNull ScrollArea parent, @NotNull File file) {
            super(parent, file);
        }

        @Override
        public void onClick(ScrollAreaEntry entry) {
            if (!this.resourceUnfriendlyFileName) {
                long now = System.currentTimeMillis();
                if (now - this.lastClick < 400L) {
                    if (this.file.isDirectory()) {
                        SaveFileScreen.this.setDirectory(this.file, true);
                    } else if (this.file.isFile()) {
                        String name = this.file.getName();
                        if (SaveFileScreen.this.forcedFileExtension == null || name.toLowerCase().endsWith("." + SaveFileScreen.this.forcedFileExtension.toLowerCase())) {
                            SaveFileScreen.this.fileNameEditBox.setValue(name);
                        }
                    }
                }
                SaveFileScreen.this.updatePreview(this.file);
                this.lastClick = now;
            }
        }
    }
}