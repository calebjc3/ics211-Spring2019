package edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Represents a PilsnerTest.
 *
 * @author Cam Moore
 *
 */
public class IndiaPaleAleTest {

  /**
   * Test method for {@link edu.ics211.h01.IndiaPaleAle#IndiaPaleAle(java.lang.String)}.
   */
  @Test
  public void testIndiaPaleAleString() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Best Ipa");
    assertNotNull("Should have created an India Pale Ale", ipa);
    assertEquals("Should have the right name", "My Best IPA", ipa.getName());
    assertTrue("Should have valid ibu", ipa.getIbu() > 24 && ipa.getIbu() < 46);
    assertTrue("Should have valid abv", ipa.getAbv() >= 4.2 && ipa.getAbv() <= 6.0);
  }


  /**
   * Test method for {@link edu.ics211.h01.IndiaPaleAle#IndiaPaleAle(java.lang.String,
   *  java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testIndiaPaleAleStringIntegerDouble() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Monday IPA", 35, 5.0);
    assertNotNull("Should have created an India Pale Ale", ipa);
    assertEquals("Should have the right name", "My Monday IPA", ipa.getName());
    assertTrue("Should have the right ibu", 35 == ipa.getIbu());
    assertEquals("Should have the right name", 5.0, ipa.getAbv(), 0.0001);
    try {
      ipa = new IndiaPaleAle("Bad, Bad, Bad", 100, 5.0);
      fail("Should not create an IndiaPaleAle with that IBU");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      ipa = new IndiaPaleAle("Bad, Bad, Bad", 35, 10.0);
      fail("Should not create an IndiaPaleAle with that ABV");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
  }


  /**
   * Test method for {@link edu.ics211.h01.Beer#setName(java.lang.String)}.
   */
  @Test
  public void testSetName() {
    IndiaPaleAle ipa = new IndiaPaleAle("My Poorly Named Ipa", 35, 5.0);
    assertEquals("Should have the right name", "My Poorly Named Ipa", ipa.getName());
    ipa.setName("Best Ipa");
    assertEquals("Should have the right name", "Best Ipa", ipa.getName());
  }
}