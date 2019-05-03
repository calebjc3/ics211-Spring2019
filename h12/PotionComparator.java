package edu.ics211.h12;

import java.util.Comparator;

/** Declares PotionComparator class implementing Comparator.
 * 
 * @author caleb cheshire
 *
 */
public class PotionComparator implements Comparator<Potion> {

  /** Declares compare integer variable.
   * 
   * @param p1 p1
   * @param p2 p2
   * @return p1 p2
   */
  public int compare(Potion p1, Potion p2) {
    return p1.hashCode() - p2.hashCode();
  }
}
