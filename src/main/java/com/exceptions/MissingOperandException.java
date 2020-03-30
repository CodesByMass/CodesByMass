package com.exceptions;

/**
 * Vérifie si une opération peut être effectuée sur deux opérandes.
 *
 * @author Mass'
 *
 */
@SuppressWarnings("serial")
public class MissingOperandException extends Exception {

  public MissingOperandException() {
    super("Il manque au moins un op�rande !");
  }

}
