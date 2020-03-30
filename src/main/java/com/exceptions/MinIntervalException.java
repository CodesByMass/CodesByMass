package com.exceptions;


/**
 * Gère la valeur minimale autorisée pour les opérandes.
 *
 * @author Mass'
 *
 */
@SuppressWarnings("serial")
public class MinIntervalException extends Exception {

  public MinIntervalException(double min, double max) {
    super(" Le nombre est inf�rieur � la borne inf�rieure de l'intervalle [" + min + ", " + max
        + "]");
  }

}
