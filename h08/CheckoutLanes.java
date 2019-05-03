package edu.ics211.h08;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates the CheckoutLanes class that implements ICheckoutLanes.
 *
 * @author Caleb Cheshire
 *        Found help for simulateCheckout method at: https://stackoverflow.com/a/858590
 */
public class CheckoutLanes implements ICheckoutLanes {
  private int express;
  private int regular;
  
  private ArrayList<CircularArrayQueue<Shopper>> expressLanes 
      = new ArrayList<CircularArrayQueue<Shopper>>();
  private ArrayList<CircularArrayQueue<Shopper>> regularLanes 
      = new ArrayList<CircularArrayQueue<Shopper>>();

  /**
   * Constructor for CheckoutLanes.
   *
   * @param numExpress number of express lanes.
   * @param numRegular number of regular lanes.
   */
  public CheckoutLanes(int numExpress, int numRegular) {
    //must be at least 1 regular lane.
    if (numRegular == 0) {
      throw new IllegalArgumentException();
    }
    this.express = numExpress;
    this.regular = numRegular;
    
    // creates circular array queue for each lane in the constructor.
    for (int i = 0; i < numExpress; i++) {
      expressLanes.add(new CircularArrayQueue<Shopper>());
    }
    for (int j = 0; j < numRegular; j++) {
      regularLanes.add(new CircularArrayQueue<Shopper>());
    }
  }

  /**
   * Adds shopper to lane.
   *
   * @param laneNumber number of the lane
   * @param shopper the shopper
   */
  @Override
  public void enterLane(int laneNumber, Shopper shopper) {
    if (laneNumber >= 0 && laneNumber < express) {
      expressLanes.get(laneNumber).add(shopper);
    } else if (laneNumber >= express) {
      regularLanes.get(laneNumber - express).add(shopper);
    }
  }

  /**
   * Simulates the checkout process.
   *
   * @return A list of shoppers in the order they are finished.
   */
  @Override
  public List<Shopper> simulateCheckout() {
    // # credit: https://stackoverflow.com/a/858590
    List<Shopper> checkedOut = new ArrayList<Shopper>();

    // runs till all the lanes are empty
    while (!expressEmpty() || !regularEmpty()) {
      for (int j = 0; j < express + regular; j++) {
        if (j < express) {
          if (expressLanes.get(j).size() == 0) {
            continue;
          }

          // # credit: https://stackoverflow.com/a/363732
          if (expressLanes.get(j).peek().getNumberOfItems() > 11) {
            int randomLane = express + (int)(Math.random() * ((regular - express) + 1));

            // move shopper with too many items
            Shopper shopperToMove = expressLanes.get(j).poll();
            regularLanes.get(randomLane - express).offer(shopperToMove);

            System.out.println("Express Lane Shopper with " 
                  + shopperToMove.getNumberOfItems() + " items moved to lane " + randomLane + ".");
          } else {
            Shopper checked = expressLanes.get(j).poll();

            checkedOut.add(checked);

            System.out.println("Express Lane " + j + ", shopper had " 
                  + checked.getNumberOfItems() + " items.");
          }
        } else { 
          int counter = j - express;

          if (regularLanes.get(counter).size() == 0) {
            continue;
          }
          Shopper checked = regularLanes.get(counter).poll();
          checkedOut.add(checked);
          System.out.println("Regular Lane " + (counter) + ", shopper had " 
                + checked.getNumberOfItems() + " items.");
        }
      }
    }

    return checkedOut;
  }

  private boolean expressEmpty() {
    if (express == 0) {
      return true;
    }

    boolean empty = false;

    //Checks for remaining express shoppers.
    for (int i = 0; i < express; i++) {
      if (expressLanes.get(i).size() == 0) {
        empty = true;
      } else {
        return false;
      }
    }

    return empty;
  }

  private boolean regularEmpty() {
    boolean empty = false;

    // Checks for remaining regular shoppers.
    for (int i = 0; i < regular; i++) {
      if (regularLanes.get(i).size() == 0) {
        empty = true;
      } else {
        return false;
      }
    }
    return empty;
  }
}