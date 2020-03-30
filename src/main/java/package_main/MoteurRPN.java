package package_main;

import java.util.EmptyStackException;
import java.util.Stack;
import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_exceptions.MissingOperandException;

/**
 * Hérite d'interpreteur et permet de faire diverses commandes.
 *
 * <
 *
 * @author Mass'
 *
 */
public class MoteurRPN extends Interpreteur {

  public final double MAX_VALUE = 2000000;
  public final double MIN_VALUE = 0;

  // Création de la pile
  public MoteurRPN() {
    super();
  }

  /**
   *
   * @return la pile d'opérandes
   */
  public Stack<Double> get_stack() {
    return this.numbers_stack;
  }

  /**
   *
   * @return historique des deux derniers éléments retirés de la pile
   */
  public Stack<Double> get_log() {
    return this.log_numbers;
  }

  /**
   * Ajoute un opérande à la pile.
   *
   * @param operand le nombre saisi
   * @throws MinIntervalException valeur maximale autorisée
   * @throws MaxIntervalException valeur minimale autorisée
   */
  public void addOperand(double operand) throws MinIntervalException, MaxIntervalException {
    if (operand < MIN_VALUE) {
      throw new MinIntervalException(MIN_VALUE, MAX_VALUE);
    } else if (operand > MAX_VALUE) {
      throw new MaxIntervalException(MIN_VALUE, MAX_VALUE);
    }
    numbers_stack.push(operand);

  }

  /**
   * Fait une opération sur deux opérandes.
   *
   * @param op l'opérateur saisi.
   * @throws MissingOperandException quand il manque au moins un opérateur dans la pile.
   * @throws MinIntervalException valeur maximale autorisée dépassée.
   * @throws MaxIntervalException valeur minimal autorisée dépassée.
   */
  public void compute(Operation op)
      throws MissingOperandException, MinIntervalException, MaxIntervalException {
    double operandA = MIN_VALUE;
    double operandB = MIN_VALUE;
    if (numbers_stack.size() >= 2) {
      try {
        operandA = numbers_stack.pop();
        operandB = numbers_stack.pop();
        this.log_numbers.add(operandA);
        this.log_numbers.add(operandB);
        System.out.println("l'operation effectuée est :(" + operandB + "" + op.getOperation() + ""
            + operandA + ") = " + op.eval(operandA, operandB));
        this.addOperand(op.eval(operandB, operandA));
      } catch (ArithmeticException | MinIntervalException | MaxIntervalException e) {
        System.out.println("Exception: " + e.getMessage());
        if (operandA != Double.MIN_VALUE)
          this.addOperand(operandB);
        if (operandB != Double.MIN_VALUE)
          this.addOperand(operandA);
      } catch (EmptyStackException e) {
        System.out.println("Exception: " + e.getMessage());
      }
    } else
      throw new MissingOperandException();

  }

  /**
   * Affiche la liste des opérateurs.
   *
   * @return la liste des opérandes de la pile
   */
  public String getOperands() {
    String operands = "La pile contient \n ";
    for (double operand : this.numbers_stack) {
      operands += operand + " ";
    }
    return operands;

  }

}
