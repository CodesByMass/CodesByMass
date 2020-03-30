package package_main;

import java.util.Scanner;
import package_commands.AddOperand;
import package_commands.Computer;
import package_commands.ListOperands;
import package_commands.Quit;
import package_commands.Undo;
import package_exceptions.MissingOperandException;

/**
 * Gère les interactions avec l'utilisateur et invoque le moteurRPN
 *
 * @see MoteurRPN
 *
 * @author Mass'
 *
 */
public class SaisieRPN {

  MoteurRPN moteurRPN;
  CommandsFactory cf;

  public SaisieRPN() {
    moteurRPN = new MoteurRPN();
    cf = new CommandsFactory();
  }

  // Initialiser

  /**
   * Affiche l'interface console à l'utilisateur et gère les input.
   *
   * @throws MissingOperandException Si il manque un operand pour une opération.
   */
  public void userInteraction() throws MissingOperandException {
    Scanner sc = new Scanner(System.in);
    System.out
        .println(" Veuillez entrez un Opérande | exit pour quitter | restart pour vider la pile ");
    String input = sc.nextLine();
    double new_operand;

    while (!input.equals("exit")) {
      try {
        switch (input) {
          case "quit": {
            cf.addCommand("quitter", new Quit(moteurRPN));
            cf.execute("quitter");
            break;
          }
          case "undo": {
            cf.addCommand("undo", new Undo(moteurRPN, CommandsFactory.last_Command));
            cf.execute("undo");
            break;
          }
          case "+": {
            cf.addCommand("Computer", new Computer(moteurRPN, Operation.PLUS));
            cf.execute("Computer");
            break;
          }
          case "-": {
            cf.addCommand("Computer", new Computer(moteurRPN, Operation.MOINS));
            cf.execute("Computer");
            break;
          }
          case "*": {
            cf.addCommand("Computer", new Computer(moteurRPN, Operation.MULT));
            cf.execute("Computer");
            break;
          }
          case "/": {
            cf.addCommand("Computer", new Computer(moteurRPN, Operation.DIV));
            cf.execute("Computer");
            break;
          }
          case "%": {
            cf.addCommand("Computer", new Computer(moteurRPN, Operation.MOD));
            cf.execute("Computer");
            break;
          }
          case "restart": {
            moteurRPN.get_stack().clear();
            System.out.println(" La pile est vidée ");
            break;
          }
          default: {
            new_operand = new Double(input);
            cf.addCommand("addOperand", new AddOperand(moteurRPN, new_operand));
            cf.execute("addOperand");
            break;
          }
        }
      } // Si on écrit un caractère spécial par exemple
      catch (NumberFormatException e) {
        System.out.println("Caractères incorrectes");
      }

      finally {
        cf.addCommand("getOperands", new ListOperands(moteurRPN));
        cf.execute("getOperands");
        input = sc.nextLine();
      }

    }
    sc.close();
  }
}
