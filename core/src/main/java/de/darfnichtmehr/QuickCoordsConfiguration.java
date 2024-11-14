package de.darfnichtmehr;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.client.gui.screen.widget.widgets.input.MultiKeybindWidget.MultiKeyBindSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget.TextFieldSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;

@ConfigName("settings")
public class QuickCoordsConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @TextFieldSetting
  private final ConfigProperty<String> format = new ConfigProperty<>("X: %x% Y: %y% Z: %z%");

  @SwitchSetting
  private final ConfigProperty<Boolean> enableCommand = new ConfigProperty<>(true);

  @MultiKeyBindSetting
  private final ConfigProperty<Key[]> clipboardKeys = new ConfigProperty<>(new Key[0]);

  @SettingSection("chatPlaceholder")
  @SwitchSetting
  private final ConfigProperty<Boolean> enableChatPlaceholder = new ConfigProperty<>(true);

  @TextFieldSetting
  private final ConfigProperty<String> chatPlaceholder = new ConfigProperty<>("[coords]");

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<String> format() {
    return this.format;
  }

  public ConfigProperty<Boolean> enableCommand() {
    return this.enableCommand;
  }

  public ConfigProperty<Key[]> clipboardKeys() {
    return this.clipboardKeys;
  }

  public ConfigProperty<Boolean> enableChatPlaceholder() {
    return this.enableChatPlaceholder;
  }

  public ConfigProperty<String> chatPlaceholder() {
    return this.chatPlaceholder;
  }

}
