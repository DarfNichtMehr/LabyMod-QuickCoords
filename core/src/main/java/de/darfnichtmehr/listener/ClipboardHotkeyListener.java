package de.darfnichtmehr.listener;

import de.darfnichtmehr.QuickCoordsAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.input.KeyEvent;
import net.labymod.api.event.client.input.KeyEvent.State;

public class ClipboardHotkeyListener {

  private final QuickCoordsAddon ADDON;

  public ClipboardHotkeyListener(QuickCoordsAddon addon) {
    this.ADDON = addon;
  }

  @Subscribe
  public void onKey(KeyEvent event) {
    if (event.state() != State.PRESS
        || Laby.labyAPI().minecraft().minecraftWindow().isScreenOpened()) {
      return;
    }

    Key[] keys = ADDON.configuration().clipboardKeys().get();

    if (keys.length == 0) {
      return;
    }

    for (Key key : keys) {
      if (!key.isPressed()) {
        return;
      }
    }

    Laby.labyAPI().minecraft().setClipboard(ADDON.getFormattedCoordinates());
    ADDON.displayMessage(
        Component.translatable("quickcoords.messages.hotkeys.clipboard", NamedTextColor.GREEN));
  }

}
