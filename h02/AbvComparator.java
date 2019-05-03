/**
 * 
 */

package edu.ics211.h02;

import java.util.Comparator;

/** Declare class Abvcomparator.
 * @author caleb
 *
 */
public class AbvComparator implements Comparator<Beer> {

  /** Declare comparator method.
   * 
   */
  public AbvComparator() {
  }

  @Override
  public int compare(Beer b0, Beer b1) {
    return b0.ibu.compareTo(b1.ibu);
  }
}
