package com.commands;

import com.principal.Interpreteur;

/**
 * Commande qui permet de quitter l'application.
 *
 * @see Interpreteur#quit()
 *
 * @author Mass'
 *
 */
public class Quit implements Command {

  private final Interpreteur interpreteur;

  public Quit(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    interpreteur.quit();
  }

}
