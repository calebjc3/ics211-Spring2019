package edu.ics211.h05;

import java.util.Comparator;

/**Declares IntegerComparator.
 * @author caleb
 *
 */
public class IntegerComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
   
    return o1 - o2;
  }

}
