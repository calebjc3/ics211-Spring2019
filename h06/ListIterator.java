package edu.ics211.h06;

/**
 * ListIterator interface.
 * @author Caleb Cheshire
 * @param <E> Generic object
 */
public interface ListIterator<E> {
  /**
   * Checks if there is an object in the next node.
   * @return true if this list iterator has more elements while traversing in the forward direction.
   */
  boolean hasNext(); 
  /**
   * Checks if there is an object in the previous node.
   * @return true if this list iterator has more elements while traversing in the reverse direction.
   */
  
  /** hasPrevious method.
   * 
   * @return return
   */
  boolean hasPrevious(); // Returns true if this list has more elements while in reverse.
  
  /** E next method.
   * 
   * @return return
   */
  E next(); // Returns the next Element.
  
  /** nextIndex method.
   * 
   * @return return
   */
  int nextIndex(); // Returns the index of the next element.
  
  /** E previous method.  
   * 
   * @return return
   */
  E previous(); // Returns the previous Element
  
  /** previousIndex method.
   * 
   * @return return
   */
  int previousIndex(); // Returns the index of the previous element.
  
  /** remove method.
   * 
   */
  void remove(); // Removes from the list the last element that was returned.
  
  /** set method.
   * 
   * @param e e
   */
  void set(E e); // Replaces the last element returned. (Optional for this assignment)
}