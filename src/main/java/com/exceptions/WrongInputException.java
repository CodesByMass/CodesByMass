package com.exceptions;

/**
 * Vérifie les saisies incorrectes de l'utilisateur.
 *
 * @author Mass'
 *
 */

@SuppressWarnings("serial")
public class WrongInputException extends Exception {

  public WrongInputException() {
    super("entree incorrecte");
  }

}
