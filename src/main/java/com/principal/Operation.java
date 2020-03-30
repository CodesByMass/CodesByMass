package com.principal;

/**
 * Types d'opérations possibles.
 *
 * @author Mass'
 *
 */
public enum Operation {

  // Double bien plus pr�cis qu'un float
  PLUS('+') {
    @Override
    public double eval(double operandA, double operandB) {
      return operandA + operandB;
    }
  },
  MOINS('-') {

    @Override
    public double eval(double operandA, double operandB) {
      return operandA - operandB;
    }
  },
  MULT('*') {
    @Override
    public double eval(double operandA, double operandB) {
      return operandA * operandB;
    }
  },
  DIV('/') {
    @Override
    public double eval(double operandA, double operandB) throws ArithmeticException {
      if (operandB == 0) {
        throw new ArithmeticException("Division par 0 impossible !");
      } else {
        return operandA / operandB;
      }
    }
  },
  MOD('%') {
    @Override
    public double eval(double operandA, double operandB) {
      if (operandB == 0) {
        throw new ArithmeticException("Division par 0 impossible !");
      }
      return operandA % operandB;
    }
  };

  private char symbole;

  Operation(char symbole) {
    this.symbole = symbole;
  }

  public abstract double eval(double operand1, double operand2);

  public char getOperation() {
    return symbole;
  }

}
