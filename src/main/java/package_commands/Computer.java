package package_commands;

import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_exceptions.MissingOperandException;
import package_main.MoteurRPN;
import package_main.Operation;

public class Computer implements Command {

  private MoteurRPN moteur;
  private Operation op;

  public Computer(MoteurRPN moteur, Operation operation) {
    this.moteur = moteur;
    this.op = operation;
  }

  @Override
  public void execute() {
    try {
      this.moteur.compute(op);
    } catch (MissingOperandException | MinIntervalException | MaxIntervalException e) {
      e.printStackTrace();
    }

  }


}
