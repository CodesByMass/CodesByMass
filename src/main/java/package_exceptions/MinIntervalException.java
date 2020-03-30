package package_exceptions;
@SuppressWarnings("serial")
public class MinIntervalException extends Exception {

  public MinIntervalException(double min, double max) {
    super(" Le nombre est inférieur à la borne inférieure de l'intervalle [" + min + ", " + max
        + "]");
  }

}
