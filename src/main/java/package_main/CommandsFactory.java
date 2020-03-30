package package_main;

import java.util.HashMap;
import package_commands.Command;

/**
 * Fait office d'Invoker, appelle les commandes qu'il faut.
 *
 * @author Mass'
 *
 */
public class CommandsFactory {

  // Dernière commande
  public static String last_Command;
  // Map des commandes
  private final HashMap<String, Command> commandMap = new HashMap<String, Command>();

  /**
   * Ajoute une commande à la liste des commandes actuelles
   *
   * @param cmdName nom de la commande
   * @param command type de commande
   */
  public void addCommand(String cmdName, Command command) {
    commandMap.put(cmdName, command);
  }

  /**
   * Execute la commande
   *
   * @param cmdName nom de la commande, permet de rechercher si la commande existe dans la liste.
   */
  public void execute(String cmdName) {
    Command command = commandMap.get(cmdName);
    if (command == null) {
      throw new IllegalStateException("Aucun commande de type " + cmdName);
    }
    command.execute();
    last_Command = cmdName;
    commandMap.remove(cmdName);
  }

}
