package com.commands;

import com.exceptions.MaxIntervalException;
import com.exceptions.MinIntervalException;
import com.exceptions.MissingOperandException;
import com.principal.MoteurRpn;
import com.principal.Operation;

/**
 * Commande qui permet de faire une opération sur deux opérandes.
 *
 * @see MoteurRpn#compute(Operation)
 *
 * @author Mass'
 *
 */
public class Computer implements Command {

  private MoteurRpn moteur;
  private Operation op;

  /**
   * Instancie la commande.
   *
   * @param moteur envoie l'instance du moteurRPN
   * @param operation envoie l'operateur saisi
   * @see Operation
   */
  public Computer(MoteurRpn moteur, Operation operation) {
    this.moteur = moteur;
    this.op = operation;
  }

  /**
   * Implémente la méthode execute.
   */
  @Override
  public void execute() {
    try {
      this.moteur.compute(op);
    } catch (MissingOperandException | MinIntervalException | MaxIntervalException e) {
      e.printStackTrace();
    }

  }


}
