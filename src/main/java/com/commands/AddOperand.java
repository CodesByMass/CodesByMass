package com.commands;

import com.exceptions.MaxIntervalException;
import com.exceptions.MinIntervalException;
import com.principal.MoteurRpn;

/**
 * Commande qui permet d'ajouter un opérande à la liste des opérandes.
 *
 * @see MoteurRpn#addOperand(double)
 *
 * @author Mass'
 *
 */
public class AddOperand implements Command {

  private MoteurRpn moteur;
  private double op;

  public AddOperand(MoteurRpn moteur, double op) {
    this.moteur = moteur;
    this.op = op;
  }

  /**
   * Implémente la méthode execute.
   *
   *
   */
  @Override
  public void execute() {
    try {
      moteur.addOperand(op);
    } catch (MinIntervalException | MaxIntervalException e) {
      e.printStackTrace();
    }
  }

}
