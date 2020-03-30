package package_exceptions;
public class MaxIntervalException extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 7961312093542442297L;

  public MaxIntervalException(double min, double max) {
    super(" Le nombre est supérieur à la borne supérieure de l'intervalle [" + min + ", " + max
        + "]");
  }
}
