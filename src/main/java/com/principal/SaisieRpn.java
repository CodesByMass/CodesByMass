package com.principal;

import java.util.Scanner;
import com.commands.AddOperand;
import com.commands.Computer;
import com.commands.ListOperands;
import com.commands.Quit;
import com.commands.Undo;
import com.exceptions.MissingOperandException;

/**
 * Gère les interactions avec l'utilisateur et invoque le moteurRPN.
 *
 * @see MoteurRpn
 *
 * @author Mass'
 *
 */
public class SaisieRpn {

  MoteurRpn moteurRpn;
  CommandsFactory cf;

  public SaisieRpn() {
    moteurRpn = new MoteurRpn();
    cf = new CommandsFactory();
  }

  // Initialiser

  /**
   * Affiche l'interface console à l'utilisateur et gère les input.
   *
   * @throws MissingOperandException Si il manque un operand pour une opération.
   */
  public void userInteraction() throws MissingOperandException {
    Scanner sc = new Scanner(System.in, "UTF-8");
    System.out
        .println(" Veuillez entrez un Opérande | exit pour quitter | restart pour vider la pile ");
    String input = sc.nextLine();
    double newOperand;

    while (!input.equals("exit")) {
      try {
        switch (input) {
          case "quit": {
            cf.addCommand("quitter", new Quit(moteurRpn));
            cf.execute("quitter");
            break;
          }
          case "undo": {
            cf.addCommand("undo", new Undo(moteurRpn, CommandsFactory.last_Command));
            cf.execute("undo");
            break;
          }
          case "+": {
            cf.addCommand("Computer", new Computer(moteurRpn, Operation.PLUS));
            cf.execute("Computer");
            break;
          }
          case "-": {
            cf.addCommand("Computer", new Computer(moteurRpn, Operation.MOINS));
            cf.execute("Computer");
            break;
          }
          case "*": {
            cf.addCommand("Computer", new Computer(moteurRpn, Operation.MULT));
            cf.execute("Computer");
            break;
          }
          case "/": {
            cf.addCommand("Computer", new Computer(moteurRpn, Operation.DIV));
            cf.execute("Computer");
            break;
          }
          case "%": {
            cf.addCommand("Computer", new Computer(moteurRpn, Operation.MOD));
            cf.execute("Computer");
            break;
          }
          case "restart": {
            moteurRpn.get_stack().clear();
            System.out.println(" La pile est vidée ");
            break;
          }
          default: {
            newOperand = new Double(input);
            cf.addCommand("addOperand", new AddOperand(moteurRpn, newOperand));
            cf.execute("addOperand");
            break;
          }
        }
      } // Si on écrit un caractère spécial par exemple
      catch (NumberFormatException e) {
        System.out.println("Caractères incorrectes");
      }

      finally {
        cf.addCommand("getOperands", new ListOperands(moteurRpn));
        cf.execute("getOperands");
        input = sc.nextLine();
      }

    }
    sc.close();
  }
}
