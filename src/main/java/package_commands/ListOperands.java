package package_commands;

import package_main.MoteurRPN;

public class ListOperands implements Command {

  private MoteurRPN moteur;

  public ListOperands(MoteurRPN moteur) {
    this.moteur = moteur;
  }

  @Override
  public void execute() {
    this.moteur.getOperands();
  }

}
