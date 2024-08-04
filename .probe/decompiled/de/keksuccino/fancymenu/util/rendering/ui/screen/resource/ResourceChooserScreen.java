package de.keksuccino.fancymenu.util.rendering.ui.screen.resource;

import de.keksuccino.fancymenu.customization.layout.LayoutHandler;
import de.keksuccino.fancymenu.customization.placeholder.PlaceholderParser;
import de.keksuccino.fancymenu.util.LocalizationUtils;
import de.keksuccino.fancymenu.util.cycle.LocalizedGenericValueCycle;
import de.keksuccino.fancymenu.util.file.FileFilter;
import de.keksuccino.fancymenu.util.file.GameDirectoryUtils;
import de.keksuccino.fancymenu.util.file.type.FileType;
import de.keksuccino.fancymenu.util.file.type.groups.FileTypeGroup;
import de.keksuccino.fancymenu.util.file.type.groups.FileTypeGroups;
import de.keksuccino.fancymenu.util.file.type.types.AudioFileType;
import de.keksuccino.fancymenu.util.file.type.types.ImageFileType;
import de.keksuccino.fancymenu.util.file.type.types.TextFileType;
import de.keksuccino.fancymenu.util.file.type.types.VideoFileType;
import de.keksuccino.fancymenu.util.rendering.RenderingUtils;
import de.keksuccino.fancymenu.util.rendering.ui.UIBase;
import de.keksuccino.fancymenu.util.rendering.ui.screen.CellScreen;
import de.keksuccino.fancymenu.util.rendering.ui.screen.filebrowser.ChooseFileScreen;
import de.keksuccino.fancymenu.util.rendering.ui.tooltip.Tooltip;
import de.keksuccino.fancymenu.util.rendering.ui.tooltip.TooltipHandler;
import de.keksuccino.fancymenu.util.rendering.ui.widget.button.CycleButton;
import de.keksuccino.fancymenu.util.rendering.ui.widget.button.ExtendedButton;
import de.keksuccino.fancymenu.util.rendering.ui.widget.editbox.ExtendedEditBox;
import de.keksuccino.fancymenu.util.resource.Resource;
import de.keksuccino.fancymenu.util.resource.ResourceSourceType;
import de.keksuccino.fancymenu.util.resource.resources.audio.IAudio;
import de.keksuccino.fancymenu.util.resource.resources.text.IText;
import de.keksuccino.fancymenu.util.resource.resources.texture.ITexture;
import de.keksuccino.fancymenu.util.resource.resources.texture.SimpleTexture;
import de.keksuccino.fancymenu.util.resource.resources.video.IVideo;
import java.io.File;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResourceChooserScreen<R extends Resource, F extends FileType<R>> extends CellScreen {

    private static final Logger LOGGER = LogManager.getLogger();

    protected static final SimpleTexture WARNING_TEXTURE = SimpleTexture.location(new ResourceLocation("fancymenu", "textures/warning_framed_24x24.png"));

    @Nullable
    protected FileTypeGroup<F> allowedFileTypes;

    @Nullable
    protected FileFilter fileFilter;

    @NotNull
    protected Consumer<String> resourceSourceCallback;

    @Nullable
    protected String resourceSource;

    @NotNull
    protected ResourceSourceType resourceSourceType = ResourceSourceType.LOCATION;

    protected boolean allowLocation = true;

    protected boolean allowLocal = true;

    protected boolean allowWeb = true;

    protected CycleButton<ResourceSourceType> resourceSourceTypeCycleButton;

    protected ExtendedEditBox editBox;

    protected boolean showWarningLegacyLocal = false;

    protected boolean showWarningNoExtension = false;

    protected boolean warningHovered = false;

    @NotNull
    public static ResourceChooserScreen<Resource, FileType<Resource>> generic(@Nullable FileTypeGroup<FileType<Resource>> fileTypes, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(Component.translatable("fancymenu.resources.chooser_screen.choose.generic"), fileTypes, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<Resource, FileType<Resource>> generic(@NotNull Component title, @Nullable FileTypeGroup<FileType<Resource>> fileTypes, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(title, fileTypes, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<ITexture, ImageFileType> image(@NotNull Component title, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(title, FileTypeGroups.IMAGE_TYPES, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<ITexture, ImageFileType> image(@Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return image(Component.translatable("fancymenu.resources.chooser_screen.choose.image"), fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IAudio, AudioFileType> audio(@NotNull Component title, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(title, FileTypeGroups.AUDIO_TYPES, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IAudio, AudioFileType> audio(@Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return audio(Component.translatable("fancymenu.resources.chooser_screen.choose.audio"), fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IVideo, VideoFileType> video(@NotNull Component title, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(title, FileTypeGroups.VIDEO_TYPES, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IVideo, VideoFileType> video(@Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return video(Component.translatable("fancymenu.resources.chooser_screen.choose.video"), fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IText, TextFileType> text(@NotNull Component title, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return new ResourceChooserScreen<>(title, FileTypeGroups.TEXT_TYPES, fileFilter, resourceSourceCallback);
    }

    @NotNull
    public static ResourceChooserScreen<IText, TextFileType> text(@Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        return text(Component.translatable("fancymenu.resources.chooser_screen.choose.text"), fileFilter, resourceSourceCallback);
    }

    public ResourceChooserScreen(@NotNull Component title, @Nullable FileTypeGroup<F> allowedFileTypes, @Nullable FileFilter fileFilter, @NotNull Consumer<String> resourceSourceCallback) {
        super(title);
        this.allowedFileTypes = allowedFileTypes;
        this.fileFilter = fileFilter;
        this.resourceSourceCallback = resourceSourceCallback;
    }

    @Override
    protected void initCells() {
        LocalizedGenericValueCycle<ResourceSourceType> sourceTypeCycle = ResourceSourceType.LOCATION.cycle();
        if (!this.allowLocation) {
            sourceTypeCycle.removeValue(ResourceSourceType.LOCATION);
        }
        if (!this.allowLocal) {
            sourceTypeCycle.removeValue(ResourceSourceType.LOCAL);
        }
        if (!this.allowWeb) {
            sourceTypeCycle.removeValue(ResourceSourceType.WEB);
        }
        if (sourceTypeCycle.getValues().isEmpty()) {
            throw new IllegalStateException("There needs to be at least one allowed source type!");
        } else {
            if (!sourceTypeCycle.getValues().contains(this.resourceSourceType)) {
                this.resourceSource = null;
                this.resourceSourceType = (ResourceSourceType) sourceTypeCycle.getValues().get(0);
            }
            boolean isLocal = this.resourceSourceType == ResourceSourceType.LOCAL;
            boolean isLegacyLocal = isLocal && this.resourceSource != null && !this.resourceSource.trim().isEmpty() && !this.resourceSource.startsWith("config/fancymenu/assets/") && !this.resourceSource.startsWith("/config/fancymenu/assets/");
            if (isLocal && this.resourceSource == null) {
                this.resourceSource = "/config/fancymenu/assets/";
            }
            if (isLocal && !this.resourceSource.startsWith("/") && this.resourceSource.startsWith("config/fancymenu/assets/")) {
                this.resourceSource = "/" + this.resourceSource;
            }
            this.addStartEndSpacerCell();
            this.resourceSourceTypeCycleButton = new CycleButton<>(0, 0, 20, 20, sourceTypeCycle, (value, button) -> {
                this.resourceSource = null;
                this.resourceSourceType = value;
                this.rebuild();
            });
            this.resourceSourceTypeCycleButton.setTooltipSupplier(consumes -> {
                if (this.resourceSourceType == ResourceSourceType.LOCATION) {
                    return Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.source_type.location.desc"));
                } else {
                    return this.resourceSourceType == ResourceSourceType.LOCAL ? Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.source_type.local.desc")) : Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.source_type.web.desc"));
                }
            });
            this.resourceSourceTypeCycleButton.setSelectedValue(this.resourceSourceType);
            this.addWidgetCell(this.resourceSourceTypeCycleButton, true);
            this.addCellGroupEndSpacerCell();
            this.addLabelCell(Component.translatable("fancymenu.resources.chooser_screen.source"));
            CellScreen.TextInputCell sourceInputCell = this.addTextInputCell(null, !isLegacyLocal, !isLegacyLocal);
            this.editBox = sourceInputCell.editBox;
            if (isLocal && !isLegacyLocal) {
                this.editBox.setInputPrefix("/config/fancymenu/assets/");
            }
            this.editBox.setValue(this.resourceSource != null ? this.resourceSource : "");
            this.editBox.m_94196_(0);
            this.editBox.setDisplayPosition(0);
            this.editBox.m_94208_(0);
            this.editBox.applyInputPrefixSuffixCharacterRenderFormatter();
            this.editBox.m_94186_(!isLegacyLocal);
            this.editBox.m_94151_(sx -> this.resourceSource = sx);
            sourceInputCell.setEditorCallback((sx, textInputCell) -> {
                if (isLocal && !isLegacyLocal && !sx.startsWith("/config/fancymenu/assets/")) {
                    sx = "/config/fancymenu/assets/" + sx;
                }
                this.resourceSource = sx;
            });
            sourceInputCell.setEditorPresetTextSupplier(consumes -> consumes.editBox.getValueWithoutPrefixSuffix());
            if (isLocal) {
                this.addWidgetCell(new ExtendedButton(0, 0, 20, 20, Component.translatable("fancymenu.resources.chooser_screen.choose_local"), var1x -> {
                    File startDir = LayoutHandler.ASSETS_DIR;
                    String path = this.resourceSource;
                    if (path != null) {
                        startDir = new File(GameDirectoryUtils.getAbsoluteGameDirectoryPath(path)).getParentFile();
                        if (startDir == null) {
                            startDir = LayoutHandler.ASSETS_DIR;
                        }
                    }
                    ChooseFileScreen fileChooser = new ChooseFileScreen(LayoutHandler.ASSETS_DIR, startDir, call -> {
                        if (call != null) {
                            String sx = GameDirectoryUtils.getPathWithoutGameDirectory(call.getAbsolutePath());
                            if (!sx.startsWith("/")) {
                                sx = "/" + sx;
                            }
                            sx = ResourceSourceType.LOCAL.getSourcePrefix() + sx;
                            this.setSource(sx, false);
                        }
                        this.rebuild();
                        Minecraft.getInstance().setScreen(this);
                    });
                    fileChooser.setVisibleDirectoryLevelsAboveRoot(2);
                    fileChooser.setFileTypes(this.allowedFileTypes);
                    fileChooser.setFileFilter(this.fileFilter);
                    Minecraft.getInstance().setScreen(fileChooser);
                }), true);
            }
            this.addCellGroupEndSpacerCell();
            this.addLabelCell(Component.translatable("fancymenu.resources.chooser_screen.allowed_file_types"));
            MutableComponent typesComponent = Component.translatable("fancymenu.file_browser.file_type.types.all").append(" (*)");
            if (this.allowedFileTypes != null) {
                String types = "";
                for (FileType<?> type : this.allowedFileTypes.getFileTypes()) {
                    for (String s : type.getExtensions()) {
                        if (!types.isEmpty()) {
                            types = types + ";";
                        }
                        types = types + "*." + s.toUpperCase();
                    }
                }
                Component fileTypeDisplayName = this.allowedFileTypes.getDisplayName();
                if (fileTypeDisplayName == null) {
                    fileTypeDisplayName = Component.empty();
                }
                typesComponent = Component.empty().append(fileTypeDisplayName).append(Component.literal(" (")).append(Component.literal(types)).append(Component.literal(")"));
            }
            this.addLabelCell(typesComponent.setStyle(Style.EMPTY.withColor(UIBase.getUIColorTheme().warning_text_color.getColorInt())));
            this.addCellGroupEndSpacerCell();
            this.addStartEndSpacerCell();
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partial) {
        this.updateLegacyLocalWarning();
        this.updateNoExtensionWarning();
        super.render(graphics, mouseX, mouseY, partial);
        this.renderWarning(graphics, mouseX, mouseY, partial);
        this.updateInputFieldTooltips();
    }

    protected void updateInputFieldTooltips() {
        if (!this.showWarningNoExtension && this.resourceSourceType == ResourceSourceType.LOCATION && this.editBox != null && (this.editBox.m_274382_() || this.warningHovered)) {
            TooltipHandler.INSTANCE.addTooltip(Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.source_type.location.desc.input")).setDefaultStyle(), () -> true, false, true);
        }
        if (this.showWarningLegacyLocal && this.editBox != null && (this.editBox.m_274382_() || this.warningHovered)) {
            TooltipHandler.INSTANCE.addTooltip(Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.chooser_screen.legacy_local.warning")).setDefaultStyle().setTextBaseColor(UIBase.getUIColorTheme().warning_text_color), () -> true, false, true);
        }
        if (!this.showWarningLegacyLocal && this.showWarningNoExtension && this.editBox != null && (this.editBox.m_274382_() || this.warningHovered)) {
            TooltipHandler.INSTANCE.addTooltip(Tooltip.of(LocalizationUtils.splitLocalizedLines("fancymenu.resources.chooser_screen.no_extension.warning")).setDefaultStyle().setTextBaseColor(UIBase.getUIColorTheme().warning_text_color), () -> true, false, true);
        }
    }

    protected void renderWarning(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partial) {
        if ((this.showWarningLegacyLocal || this.showWarningNoExtension) && this.editBox != null) {
            ResourceLocation loc = WARNING_TEXTURE.getResourceLocation();
            if (loc != null) {
                int h = this.editBox.m_93694_() - 4;
                int w = WARNING_TEXTURE.getAspectRatio().getAspectRatioWidth(h);
                int x = this.editBox.m_252754_() - w - 2;
                int y = this.editBox.m_252907_() + 2;
                this.warningHovered = UIBase.isXYInArea(mouseX, mouseY, x, y, w, h);
                RenderingUtils.setShaderColor(graphics, UIBase.getUIColorTheme().warning_text_color, 1.0F);
                graphics.blit(loc, x, y, 0.0F, 0.0F, w, h, w, h);
                RenderingUtils.resetShaderColor(graphics);
            }
        }
    }

    protected void updateLegacyLocalWarning() {
        this.showWarningLegacyLocal = this.resourceSourceType == ResourceSourceType.LOCAL && this.resourceSource != null && !this.resourceSource.trim().isEmpty() && !this.resourceSource.startsWith("config/fancymenu/assets/") && !this.resourceSource.startsWith("/config/fancymenu/assets/");
    }

    protected void updateNoExtensionWarning() {
        boolean emptyAssetDir = this.resourceSourceType == ResourceSourceType.LOCAL && this.resourceSource != null && this.resourceSource.equals("/config/fancymenu/assets/");
        if (!emptyAssetDir && this.resourceSource != null && !this.resourceSource.replace(" ", "").isEmpty()) {
            boolean extensionFound = false;
            if (this.allowedFileTypes == null) {
                extensionFound = true;
            } else {
                for (FileType<?> fileType : this.allowedFileTypes.getFileTypes()) {
                    for (String extension : fileType.getExtensions()) {
                        if (this.resourceSource.toLowerCase().endsWith("." + extension)) {
                            extensionFound = true;
                            break;
                        }
                    }
                    if (extensionFound) {
                        break;
                    }
                }
            }
            if (!extensionFound) {
                this.showWarningNoExtension = true;
                return;
            }
        }
        this.showWarningNoExtension = false;
    }

    public ResourceChooserScreen<R, F> setSource(@Nullable String resourceSource, boolean updateScreen) {
        if (resourceSource == null) {
            this.resourceSource = null;
            this.resourceSourceType = ResourceSourceType.LOCATION;
        } else {
            resourceSource = resourceSource.trim();
            this.resourceSourceType = ResourceSourceType.getSourceTypeOf(PlaceholderParser.replacePlaceholders(resourceSource, false));
            this.resourceSource = ResourceSourceType.getWithoutSourcePrefix(resourceSource);
        }
        if (updateScreen) {
            this.rebuild();
        }
        return this;
    }

    public ResourceChooserScreen<R, F> setAllowedFileTypes(@Nullable FileTypeGroup<F> allowedFileTypes) {
        this.allowedFileTypes = allowedFileTypes;
        this.rebuild();
        return this;
    }

    public ResourceChooserScreen<R, F> setFileFilter(@Nullable FileFilter fileFilter) {
        this.fileFilter = fileFilter;
        this.rebuild();
        return this;
    }

    public ResourceChooserScreen<R, F> setResourceSourceCallback(@NotNull Consumer<String> resourceSourceCallback) {
        this.resourceSourceCallback = (Consumer<String>) Objects.requireNonNull(resourceSourceCallback);
        return this;
    }

    public boolean isLocationSourceAllowed() {
        return this.allowLocation;
    }

    public ResourceChooserScreen<R, F> setLocationSourceAllowed(boolean allowLocation) {
        this.allowLocation = allowLocation;
        this.rebuild();
        return this;
    }

    public boolean isLocalSourceAllowed() {
        return this.allowLocal;
    }

    public ResourceChooserScreen<R, F> setLocalSourceAllowed(boolean allowLocal) {
        this.allowLocal = allowLocal;
        this.rebuild();
        return this;
    }

    public boolean isWebSourceAllowed() {
        return this.allowWeb;
    }

    public ResourceChooserScreen<R, F> setWebSourceAllowed(boolean allowWeb) {
        this.allowWeb = allowWeb;
        this.rebuild();
        return this;
    }

    @Override
    public boolean allowDone() {
        return this.resourceSource == null || this.resourceSource.replace(" ", "").isEmpty() ? false : this.resourceSourceType != ResourceSourceType.LOCAL || !this.resourceSource.equals("/config/fancymenu/assets/");
    }

    @Override
    protected void onCancel() {
        this.resourceSourceCallback.accept(null);
    }

    @Override
    protected void onDone() {
        if (this.resourceSource == null) {
            this.resourceSourceCallback.accept(null);
        } else {
            this.resourceSourceCallback.accept(this.resourceSourceType.getSourcePrefix() + this.resourceSource);
        }
    }
}