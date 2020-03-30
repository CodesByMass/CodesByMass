package package_main;
public enum Operation {

  // Double bien plus précis qu'un float
  PLUS('+') {
    @Override
    public double eval(double operand_a, double operand_b) {
      return operand_a + operand_b;
    }
  },
  MOINS('-') {

    @Override
    public double eval(double operand_a, double operand_b) {
      return operand_a - operand_b;
    }
  },
  MULT('*') {
    @Override
    public double eval(double operand_a, double operand_b) {
      return operand_a * operand_b;
    }
  },
  DIV('/') {
    @Override
    public double eval(double operand_a, double operand_b) throws ArithmeticException {
      if (operand_b == 0) {
        throw new ArithmeticException("Division par 0 impossible !");
      } else
        return operand_a / operand_b;
    }
  },
  MOD('%') {
    @Override
    public double eval(double operand_a, double operand_b) {
      if (operand_b == 0) {
        throw new ArithmeticException("Division par 0 impossible !");
      }
      return operand_a % operand_b;
    }
  };

  private char symbole;

  Operation(char symbole) {
    this.symbole = symbole;
  }

  public abstract double eval(double operand_1, double operand_2);

  public char getOperation() {
    return symbole;
  }

}
