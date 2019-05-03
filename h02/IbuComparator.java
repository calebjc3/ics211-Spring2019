/**
 * 
 */

package edu.ics211.h02;

import java.util.Comparator;

/** Declare class Ibucomparator.
 * @author caleb
 *
 */
public class IbuComparator implements Comparator<Beer> {

  /** Declare Ibucomparator method.
   * 
   */
  public IbuComparator() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public int compare(Beer b0, Beer b1) {
    // TODO Auto-generated method stub
    return b0.ibu.compareTo(b1.ibu);
  }
}
