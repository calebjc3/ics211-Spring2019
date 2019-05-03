package edu.ics211.h06;

import edu.ics211.h02.Beer;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/** public class JosephusBeerFlight.
 * 
 * @author Caleb Cheshire
 *        with help from Gabriel Elacion
 *
 */
public class JosephusBeerFlight implements IBeerTasting {
  private Beer [] myBeer;
  
  /** public class JosephusBeerFlight.
   * @param myBeer beer
   */
  public JosephusBeerFlight(Beer[] myBeer) {
    this.myBeer = myBeer;
  }
  
  @Override
  public List<Beer> tasteBeers(int start, int step, boolean isClockwise) {   
    CircularDoublyLinkedList<Beer> list = new CircularDoublyLinkedList<Beer>(myBeer);
    LinkedList<Beer> tastedBeers = new LinkedList<Beer>();   
    ListIterator<Beer> iterator = (ListIterator<Beer>) list.iterator();    
    Beer beer = null;   
    if (isClockwise == true) {
      for (int i = 0; i < start - 1; i++) {       
        iterator.next();
      }     
      while (iterator.hasNext() == true) {       
        for (int i = 0; i < step; i++) {
          beer = iterator.next();
        }   
        tastedBeers.add(beer);
        iterator.remove();
      }     
      return tastedBeers;
    } else {     
      for (int i = 0; i < start; i++) {      
        iterator.next();
      }      
      while (iterator.hasPrevious() == true) {       
        for (int i = 0; i < step; i++) {
          beer = iterator.previous();
        }        
        tastedBeers.add(beer);
        iterator.remove();
      }
      return tastedBeers;
    }
  }
}
