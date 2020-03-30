package package_commands;

import package_exceptions.MissingOperandException;
import package_main.Interpreteur;

public class Undo implements Command {

  private final Interpreteur interpreteur;

  public Undo(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    try {
      interpreteur.undo();
    } catch (MissingOperandException e) {
      e.printStackTrace();
    }
  }
}
