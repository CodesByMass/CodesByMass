package package_main;

import java.util.Stack;
import package_exceptions.MissingOperandException;

/**
 * Gert les deux commandes Undo et Quit
 *
 * @see #quit()
 * @see #quit()
 *
 * @author Mass'
 *
 */
public class Interpreteur {

  // Pile des opérandes
  protected Stack<Double> numbers_stack;
  // Historique des deux derniers opérandes retirés lors d'une opération
  protected Stack<Double> log_numbers;


  public Interpreteur() {
    this.numbers_stack = new Stack<Double>();
    this.log_numbers = new Stack<Double>();
  }


  public Interpreteur(Stack<Double> numbers_stack, Stack<Double> log_numbers) {
    this.numbers_stack = numbers_stack;
    this.log_numbers = log_numbers;

  }


  /**
   * Permet de quitter l'application.
   */
  public void quit() {
    System.out.println("Sortie du programme");
    System.exit(0);
  }

  /**
   * Annule la dernière commande saisie.
   * 
   * @param cf Dernière commande saisie par l'utilisateur
   * @throws MissingOperandException Si aucun opérande n'est dans la pile
   */
  public void undo(String cf) throws MissingOperandException {
    if (cf == ("AddOperand")) {

      if (!(numbers_stack.isEmpty())) {
        numbers_stack.pop();
      } else {
        throw new MissingOperandException();
      }
    } else if (cf == ("Computer")) {
      double op1 = this.log_numbers.pop();
      double op2 = this.log_numbers.pop();
      this.numbers_stack.pop();
      // Une pile est une LIFO, on a donc récupéré en dernier l'élément le plus ancien de la pile de
      // base
      this.numbers_stack.add(op2);
      this.numbers_stack.add(op1);
    }
  }


}

