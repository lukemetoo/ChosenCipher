package com.ChoseCipherAttack;

import java.security.NoSuchAlgorithmException;

public class Application {
  static int p = 3;
  static int q = 11;
  static int phi = (p - 1) * (q - 1);
  static int n = p * q;
  static int e = 7;
  static int d = calculateD();

  public static void main(String[] args) {

    Bob bob = new Bob(16, n, e);
    Alice alice = new Alice(n, d);
    Mallory mallory = new Mallory(n, e, 2);

    // Bob encrypts a message, Mallory intercepts and alters the ciphertext before forwarding it
    // to Alice. Alice decrypts and discards the seemingly meaningless message, which is then recovered
    // and cracked by Mallory.
    int crackedMessage = mallory.crackMessage(alice.decrypt(mallory.calCprime(bob.encrypt())));
    System.out.println(crackedMessage);

    /* try {
      byte[] key = alice.getSHA(mallory.calCprime(bob.encrypt()));

    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
    } */


  }

  public static int calculateD() {
    int x = -1;

    if(gcd(e, phi) != 1)
      return x;
    for(int i = 1; i <= phi; i++) {
      if((i * e) % phi == 1) {
        x = i;
      }
    }
    return x;
  }

  public static int gcd(int e, int phi) {
    while(phi != 0) {
      int x = phi;
      phi = e % phi;
      e = x;
    }
    return e;
  }
}
