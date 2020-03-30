package com.principal;

import com.exceptions.MissingOperandException;

/**
 * Programme principal qui lance l'application.
 *
 * @author Mass'
 *
 */
public enum CalculatriceRpn {

  CALCULATRICE(new SaisieRpn());

  private SaisieRpn inputRpn;

  CalculatriceRpn(SaisieRpn input) {
    System.out.println(" Bienvenue sur la Reverse Polish Notation Calculatrice ");
    inputRpn = input;
  }

  public void launch() throws MissingOperandException {

    inputRpn.userInteraction();
  }

  public static void main(String[] args) throws MissingOperandException {

    CalculatriceRpn.CALCULATRICE.launch();
  }

}


