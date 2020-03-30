package package_main;

import java.util.Stack;
import package_exceptions.MissingOperandException;

public class Interpreteur {

  protected Stack<Double> numbers_stack;
  protected Stack<Double> log_numbers;


  public Interpreteur() {
    this.numbers_stack = new Stack<Double>();
    this.log_numbers = new Stack<Double>();
  }


  public Interpreteur(Stack<Double> numbers_stack, Stack<Double> log_numbers) {
    this.numbers_stack = numbers_stack;
    this.log_numbers = log_numbers;

  }

  /*
   * public void executeCommand(String str) { if (this.commands.containsKey(str)) {
   * this.commands.get(str).execute(); } }
   */
  public void quit() {
    System.out.println("Vous avez quitté le programme");
    System.exit(0);
  }

  public void undo() throws MissingOperandException {

    if (!(numbers_stack.isEmpty())) {
      numbers_stack.pop();
    } else {
      throw new MissingOperandException();
    }
  }


}

