package org.sit.qe.util.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberCheckerMCDCCoverageTest {
  INumberChecker nc = null;

  @BeforeEach
  public void createNumberChecker() {
    nc = NumberCheckerFactory.create();
  }

  @Test
  public void testForNull() {
    // create tests using nc
    boolean actual = nc.isHexNumber(null);
    assertFalse(actual);
  }

  @Test
  public void testForEmptyString() {
    boolean actual = nc.isHexNumber("");
    assertFalse(actual);
  }

  @Test
  public void testForSingleChar() {
    boolean actual = nc.isHexNumber("-");
    assertFalse(actual);
  }

  @Test
  public void testForDoubleChars() {
    boolean actual = nc.isHexNumber("+-4d");
    assertFalse(actual);
  }

  @Test
  public void testFor0x() {
    boolean actual = nc.isHexNumber("0x");
    assertFalse(actual);
  }

  @Test
  public void testForFull1() {
    boolean actual = nc.isHexNumber("0X!k8cB=X");
    assertFalse(actual);
  }

  @Test
  public void testForNot0x() {
    boolean actual = nc.isHexNumber("0yb6D55c8");
    assertFalse(actual);
  }
}
