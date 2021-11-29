package com.ChoseCipherAttack;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Alice {

  private int n;
  private int d;

  public Alice(int n, int d) {
    this.d = d;
    this.n = n;
  }

  public int decrypt(double cPrime) {
    return (int) (Math.pow(cPrime, d) % n);
  }

  public byte[] getSHA(int input) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    return md.digest(BigInteger.valueOf(input).toByteArray());
  }

}
