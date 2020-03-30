package package_exceptions;
@SuppressWarnings("serial")
public class WrongInputException extends Exception {

  public WrongInputException() {
    super("entree incorrecte");
  }

}
