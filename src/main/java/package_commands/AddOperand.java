package package_commands;

import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_main.MoteurRPN;

/**
 * Commande qui permet d'ajouter un opérande à la liste des opérandes.
 *
 * @see MoteurRPN#addOperand(double)
 *
 * @author Mass'
 *
 */
public class AddOperand implements Command {

  private MoteurRPN moteur;
  private double op;

  public AddOperand(MoteurRPN moteur, double op) {
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
