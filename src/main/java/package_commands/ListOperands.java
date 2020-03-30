package package_commands;

import package_main.MoteurRPN;

/**
 * Commande qui permet d'afficher la liste des opérandes.
 *
 * @see MoteurRPN#getOperands()
 *
 * @author Mass'
 *
 */
public class ListOperands implements Command {

  private MoteurRPN moteur;

  /**
   *
   * @param moteur envoie l'instance du moteurRPN
   */
  public ListOperands(MoteurRPN moteur) {
    this.moteur = moteur;
  }

  /**
   * Implémente la méthode execute
   */
  @Override
  public void execute() {
    this.moteur.getOperands();
  }

}
