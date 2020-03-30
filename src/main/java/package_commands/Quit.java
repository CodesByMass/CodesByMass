package package_commands;

import package_main.Interpreteur;

public class Quit implements Command {

  private final Interpreteur interpreteur;

  public Quit(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    interpreteur.quit();
  }

}
