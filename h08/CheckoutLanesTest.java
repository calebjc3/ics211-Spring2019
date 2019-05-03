package edu.ics211.h08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import org.junit.Test;

/**
 * Represents a CheckoutLanesTest.
 *
 * @author Cam Moore
 *      testTwoTwo method @author Caleb Cheshire. Found help for the structure at: https://github.com/sjavella
 *
 */
public class CheckoutLanesTest {

  /**
   * Test no express lane.
   */
  @Test
  public void testNoExpress() {
    System.out.println("\nTest No Express");
    CheckoutLanes lanes = new CheckoutLanes(0, 1);
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(15));
    List<Shopper> shoppers = lanes.simulateCheckout();
    assertTrue(shoppers.get(0).getNumberOfItems() == 5);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 15);
  }

  /**
   * Test one express lane.
   */
  @Test
  public void testOneExpress() {
    System.out.println("\nTest One Express");
    CheckoutLanes lanes = new CheckoutLanes(1, 1);
    lanes.enterLane(0, new Shopper(15));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(1, new Shopper(25));
    List<Shopper> shoppers = lanes.simulateCheckout();
    assertEquals("Wrong number of shoppers", 4, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 25);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 15);
    assertTrue(shoppers.get(3).getNumberOfItems() == 5);
  }

  /**
   * One express two regular.
   */
  @Test
  public void testOneTwo() {
    System.out.println("\nTest One Express, Two Regular");
    CheckoutLanes checkout = new CheckoutLanes(1, 2);
    checkout.enterLane(0, new Shopper(15));
    checkout.enterLane(0, new Shopper(3));
    checkout.enterLane(1, new Shopper(20));
    checkout.enterLane(2, new Shopper(17));
    List<Shopper> shoppers = checkout.simulateCheckout();
    assertEquals("Wrong number of shoppers", 4, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 20);
    assertTrue(shoppers.get(1).getNumberOfItems() == 17);
    assertTrue(shoppers.get(2).getNumberOfItems() == 3);
    assertTrue(shoppers.get(3).getNumberOfItems() == 15);
  }

  /* Brief explanation of testing strategy:
  My basic testing strategy is the same as Professor Moore's above;
  Provide shoppers to enter the respective queues and run the simulateCheckout.
  Test using assert to ensure that the queues properly remove shoppers with too many items, etc.
  */
  
  /**
   * Two express two regular.
   * Found help on how to structure the test block at: https://github.com/sjavella
   */
  @Test
  public void testTwoTwo() {
    System.out.println("\nTest Two Express, Two Regular");
    CheckoutLanes checkout = new CheckoutLanes(2, 2);
    checkout.enterLane(2, new Shopper(15));
    checkout.enterLane(1, new Shopper(3));
    checkout.enterLane(1, new Shopper(14));
    checkout.enterLane(2, new Shopper(24));
    checkout.enterLane(3, new Shopper(12));
    checkout.enterLane(2, new Shopper(5));
    checkout.enterLane(3, new Shopper(71));
    checkout.enterLane(2, new Shopper(18));
    List<Shopper> shoppers = checkout.simulateCheckout();
    assertEquals("Wrong number of shoppers", 8, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 3);
    assertTrue(shoppers.get(1).getNumberOfItems() == 15);
    assertTrue(shoppers.get(2).getNumberOfItems() == 12);
    assertTrue(shoppers.get(3).getNumberOfItems() == 24);
    assertTrue(shoppers.get(4).getNumberOfItems() == 71);
    assertTrue(shoppers.get(5).getNumberOfItems() == 5);
    assertTrue(shoppers.get(6).getNumberOfItems() == 18);
    assertTrue(shoppers.get(7).getNumberOfItems() == 14);
  }

  /**
   * One express zero regular.
   */
  @Test
  public void testOneZero() {
    System.out.println("\nTest One Express, Zero Regular");
    try {
      new CheckoutLanes(1, 0);
      fail("IllegalArgumentException should be thrown.");
    } catch (IllegalArgumentException e) {
      // this is expected
    }
  }
}
