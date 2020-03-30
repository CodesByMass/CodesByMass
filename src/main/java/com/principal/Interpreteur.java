package com.principal;

import java.util.Stack;
import com.exceptions.MissingOperandException;


/**
 * Gert les deux commandes Undo et Quit.
 *
 * @see #quit()
 * @see #quit()
 *
 * @author Mass'
 *
 */
public class Interpreteur {

  // Pile des opérandes
  protected Stack<Double> numbersStack;
  // Historique des deux derniers opérandes retirés lors d'une opération
  protected Stack<Double> logNumbers;


  public Interpreteur() {
    this.numbersStack = new Stack<Double>();
    this.logNumbers = new Stack<Double>();
  }


  public Interpreteur(Stack<Double> numbersStack, Stack<Double> logNumbers) {
    this.numbersStack = numbersStack;
    this.logNumbers = logNumbers;

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
    if (cf.equals("AddOperand")) {

      if (!(numbersStack.isEmpty())) {
        numbersStack.pop();
      } else {
        throw new MissingOperandException();
      }
    } else if (cf.equals("Computer")) {
      double op1 = this.logNumbers.pop();
      double op2 = this.logNumbers.pop();
      this.numbersStack.pop();
      // Une pile est une LIFO, on a donc récupéré en dernier l'élément le plus ancien de la pile de
      // base
      this.numbersStack.add(op2);
      this.numbersStack.add(op1);
    }
  }


}

