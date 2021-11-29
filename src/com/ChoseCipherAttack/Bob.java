package com.ChoseCipherAttack;

public class Bob {
  private int e;
  private int n;
  private int message;

  public Bob(int message, int n, int e) {
    this.message = message;
    this.e = e;
    this.n = n;
  }

  public int encrypt() {
    return (int) (Math.pow(message, e) % n);
  }
}
