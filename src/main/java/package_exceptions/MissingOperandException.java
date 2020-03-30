package package_exceptions;
@SuppressWarnings("serial")
public class MissingOperandException extends Exception {

  public MissingOperandException() {
    super("Il manque au moins un opérande !");
  }

}
