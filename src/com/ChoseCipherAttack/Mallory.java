package com.ChoseCipherAttack;

public class Mallory {
  private int randomFactor;
  private int n;
  private int e;

  public Mallory(int n, int e, int randomFactor) {
    this.randomFactor = randomFactor;
    this.e = e;
    this.n = n;
  }

  public int calCprime(double c) {
    // Return the cipher(c) scaled by some known and reproducible factor
    return (int) ((c * Math.pow(randomFactor, e)) % n);
  }

  public int crackMessage(double mPrime) {
    // Return the deciphered and incomprehensible message (mPrime) with the factor divided out
    return (int) (mPrime / randomFactor);
  }
}
