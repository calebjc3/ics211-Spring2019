package edu.ics211.h04;

import edu.ics211.h02.AbvComparator;
import edu.ics211.h02.Beer;
import edu.ics211.h02.IbuComparator;
import java.util.Arrays;
import java.util.Comparator;

/** Public class SortableBeerList.
 * @author caleb
 * @param <E>
 *
 */
public class SortableBeerList<E> implements IList211<Beer> {

  private int size;
  private Beer [] theData;
  /** declare SortableBeerList.
   * @param c c
   */
  
  public SortableBeerList(Comparator<Beer> c) {
    //Create instance of Beer
    
    new SortableList<Beer>();
    
  }
  
  /**
   * Declares SortableBeerList.
   * @param ibuC ibuC
   */
  public SortableBeerList(IbuComparator ibuC) {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * Declares SortableBeerList.
   * @param abvC abvC
   */
  public SortableBeerList(AbvComparator abvC) {
    // TODO Auto-generated constructor stub
  }
  
  /** declares SortableBeerList method.
   *
   * @param index i
   * @return Beer
   */
  public Beer get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    return (Beer) theData[index];
  }

  /**
   * Sets the item at the given index.
   * @param index the index.
   * @param element the new element to set.
   * @return the old element at index.
   */
  public Beer set(int index, Beer element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    return (Beer) theData[index];
  }

  /**
   * Returns the index of the given obj or -1.
   * @param obj the object to find.
   * @return the index of the given obj or -1.
   */
  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (theData[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the size of this list.
   * @return the size of this list.
   */
  public int size() {
    return size;
  }

  /**
   * Adds e to the end of the list.
   * @param b b 
   * @return true if successful, false otherwise.
   */
  public boolean add(Beer b) {
    if (size == theData.length) {
      theData = Arrays.copyOf(theData, theData.length * 2);
    }
    theData[size] = b;
    size++;
    return true;
  }

  /**
   * Adds element to the list at the given index.
   * @param index the index.
   * @param element the element to add.
   */
  public void add(int index, Beer element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index);
    }
    if (size == theData.length) {
      theData = Arrays.copyOf(theData, theData.length * 2);
    }
    for (int i = size; i > index; i--) {
      theData[i] = theData [i - 1];
    }
    theData[index] = element;
    size++;
  }

  /**
   * Removes the element at the given index.
   * @param index the index.
   * @return The element removed from the list.
   */
  public Beer remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    Beer returnValue = theData[index];
    for (int i = index + 1; i < size; i++) {
      theData[i - 1] = theData[i];
    }
    size--;
    return returnValue;
  }
}