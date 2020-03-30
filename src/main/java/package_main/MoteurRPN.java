package package_main;

import java.util.EmptyStackException;
import java.util.Stack;
import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_exceptions.MissingOperandException;

public class MoteurRPN extends Interpreteur {

  public final double MAX_VALUE = 2000000;
  public final double MIN_VALUE = 0;

  // Création de la pile
  public MoteurRPN() {
    super();
  }

  // get de la pile
  public Stack<Double> get_stack() {
    return this.numbers_stack;
  }

  // get historique
  public Stack<Double> get_log() {
    return this.log_numbers;
  }

  // Ajouter l'opérande à la pile
  public void addOperand(double operand) throws MinIntervalException, MaxIntervalException {
    if (operand < MIN_VALUE) {
      throw new MinIntervalException(MIN_VALUE, MAX_VALUE);
    } else if (operand > MAX_VALUE) {
      throw new MaxIntervalException(MIN_VALUE, MAX_VALUE);
    }
    numbers_stack.push(operand);

  }

  // Calculer suite à la saisie d'un opérateur
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

  // Lecture de la pile
  public String getOperands() {
    String operands = "La pile contient \n ";
    for (double operand : this.numbers_stack) {
      operands += operand + " ";
    }
    return operands;

  }

}
