package com.commands;

import com.principal.MoteurRpn;

/**
 * Commande qui permet d'afficher la liste des opérandes.
 *
 * @see MoteurRpn#getOperands()
 *
 * @author Mass'
 *
 */
public class ListOperands implements Command {

  private MoteurRpn moteur;

  /**
   * Constructeur.
   *
   * @param moteur envoie l'instance du moteurRPN
   */
  public ListOperands(MoteurRpn moteur) {
    this.moteur = moteur;
  }

  /**
   * Implémente la méthode execute.
   */
  @Override
  public void execute() {
    System.out.println(this.moteur.getOperands());
  }

}
