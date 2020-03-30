package package_commands;

import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_main.MoteurRPN;

public class AddOperand implements Command {

  private MoteurRPN moteur;
  private double op;

  public AddOperand(MoteurRPN moteur, double op) {
    this.moteur = moteur;
    this.op = op;
  }

  @Override
  public void execute() {
    try {
      moteur.addOperand(op);
    } catch (MinIntervalException | MaxIntervalException e) {
      e.printStackTrace();
    }
  }

}
