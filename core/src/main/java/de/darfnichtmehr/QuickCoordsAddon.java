package de.darfnichtmehr;

import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.client.network.server.ServerData;
import net.labymod.api.models.addon.annotation.AddonMain;
import de.darfnichtmehr.commands.SendcoordsCommand;
import de.darfnichtmehr.listener.ChatPlaceholderListener;
import de.darfnichtmehr.listener.ClipboardHotkeyListener;

@AddonMain
public class QuickCoordsAddon extends LabyAddon<QuickCoordsConfiguration> {


  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new ChatPlaceholderListener(this));
    this.registerListener(new ClipboardHotkeyListener(this));

    this.registerCommand(new SendcoordsCommand(this));

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<QuickCoordsConfiguration> configurationClass() {
    return QuickCoordsConfiguration.class;
  }

  public String getFormattedCoordinates() {
    final ClientPlayer PLAYER = Laby.labyAPI().minecraft().getClientPlayer();

    return configuration().format().get()
        .replace("%x%", String.valueOf((int) Math.floor(PLAYER.getPosX())))
        .replace("%y%", String.valueOf((int) Math.floor(PLAYER.getPosY())))
        .replace("%z%", String.valueOf((int) Math.floor(PLAYER.getPosZ())));
  }

  public boolean isOnHypixel() {
    ServerData serverData = Laby.labyAPI().serverController().getCurrentServerData();
    if (serverData != null) {
      return serverData.actualAddress().getHost().equals("mc.hypixel.net");
    }
    return false;
  }
}
