package package_main;

import java.util.HashMap;
import package_commands.Command;

public class CommandsFactory {

  private final HashMap<String, Command> commandMap = new HashMap<String, Command>();

  public void addCommand(String cmdName, Command command) {
    commandMap.put(cmdName, command);
  }

  public void execute(String cmdName) {
    Command command = commandMap.get(cmdName);
    if (command == null) {
      throw new IllegalStateException("Aucun commande de type " + cmdName);
    }
    command.execute();
  }
}
