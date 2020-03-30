package package_commands;

import package_main.Interpreteur;

public class Quit implements Command {

  private Interpreteur interpreteur;

  public Quit(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  public void execute() {
    interpreteur.quit();
  }

}
