package package_commands;

import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_exceptions.MissingOperandException;
import package_main.MoteurRPN;
import package_main.Operation;

/**
 * Commande qui permet de faire une opération sur deux opérandes.
 *
 * @see MoteurRPN#compute(Operation)
 *
 * @author Mass'
 *
 */
public class Computer implements Command {

  private MoteurRPN moteur;
  private Operation op;

  /**
   *
   * @param moteur envoie l'instance du moteurRPN
   * @param operation envoie l'operateur saisi
   * @see Operation
   */
  public Computer(MoteurRPN moteur, Operation operation) {
    this.moteur = moteur;
    this.op = operation;
  }

  /**
   * Implémente la méthode execute
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
