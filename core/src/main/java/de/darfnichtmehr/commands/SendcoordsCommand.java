package de.darfnichtmehr.commands;

import de.darfnichtmehr.QuickCoordsAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.chat.command.Command;

public class SendcoordsCommand extends Command {

  private final QuickCoordsAddon ADDON;

  public SendcoordsCommand(QuickCoordsAddon addon) {
    super("sendcoords", "sc");
    this.ADDON = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!ADDON.configuration().enableCommand().get()) {
      return false;
    }

    Laby.labyAPI().minecraft().chatExecutor().chat(ADDON.getFormattedCoordinates());
    return true;
  }
}
