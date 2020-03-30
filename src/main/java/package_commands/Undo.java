package package_commands;

import package_exceptions.MissingOperandException;
import package_main.Interpreteur;

public class Undo implements Command {

  Interpreteur interpreteur;

  public Undo(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  public void execute() {
    try {
      interpreteur.undo();
    } catch (MissingOperandException e) {
      e.printStackTrace();
    }
  }
}
