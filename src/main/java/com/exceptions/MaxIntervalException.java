package com.exceptions;


/**
 * Gère la valeur maximale autorisée.
 *
 * @author Mass'
 *
 */
@SuppressWarnings("serial")
public class MaxIntervalException extends Exception {

  public MaxIntervalException(double min, double max) {
    super(" Le nombre est sup�rieur � la borne sup�rieure de l'intervalle [" + min + ", " + max
        + "]");
  }
}
