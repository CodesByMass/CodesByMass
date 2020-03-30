package com.commands;

import com.exceptions.MissingOperandException;
import com.principal.Interpreteur;

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
  private String lastCommand;

  /**
   * Constructeur.
   *
   * @param interpreteur c'est le moteurRPN
   * @param lastCommand la dernière commande saisie
   */
  public Undo(Interpreteur interpreteur, String lastCommand) {
    this.interpreteur = interpreteur;
    this.lastCommand = lastCommand;
  }

  @Override
  public void execute() {
    try {
      interpreteur.undo(lastCommand);
    } catch (MissingOperandException e) {
      e.printStackTrace();
    }
  }
}
