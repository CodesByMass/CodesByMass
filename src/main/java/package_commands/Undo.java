package package_commands;

import package_exceptions.MissingOperandException;
import package_main.Interpreteur;

/**
 * Commande qui permet de quitter l'application.
 *
 * @see Interpreteur#undo()
 *
 * @author Mass'
 *
 */
public class Undo implements Command {

  private final Interpreteur interpreteur;
  private String last_command;

  /**
   *
   * @param interpreteur c'est le moteurRPN
   * @param last_command la dernière commande saisie
   */
  public Undo(Interpreteur interpreteur, String last_command) {
    this.interpreteur = interpreteur;
    this.last_command = last_command;
  }

  @Override
  public void execute() {
    try {
      interpreteur.undo(last_command);
    } catch (MissingOperandException e) {
      e.printStackTrace();
    }
  }
}
