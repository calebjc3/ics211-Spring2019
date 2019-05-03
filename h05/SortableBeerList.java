package edu.ics211.h05;

import edu.ics211.h02.AbvComparator;
import edu.ics211.h02.Beer;
import edu.ics211.h02.IbuComparator;
import edu.ics211.h04.IList211;
import java.util.Arrays;
import java.util.Comparator;

/** Public class SortableBeerList.
 * @author caleb
 * @param <E>
 *
 */
public class SortableBeerList<E> implements IList211<Beer> {

  private DLinkedNode<E> head;

  private int size;
  private Beer [] theData;
  /**DLinkedNode.
   * 
   * @author caleb
   *
   * @param <E> E
   */
  
  private static class DLinkedNode<E> {
    private Beer data;
    private DLinkedNode<E> next;
    /**
     * Creates a node.
     * 
     * @param data the data at the node
     */
    
    private DLinkedNode(Beer data) {
      this.data = data;
      this.next = null;
    }

    /**
     * Creates a node.
     */
    private DLinkedNode(Beer data, DLinkedNode<E> next, DLinkedNode<E> prev) {
      this.data = data;
      this.next = next;
    }
  }

  /** declare SortableBeerList.
   * @param c c
   * 
   */
  public SortableBeerList(Comparator<Beer> c) {
    //Create instance of Beer
    
    new SortableList<Beer>();
    
  }
  
  /**sortableBeerList.
   * 
   * @param ibuC ibuC
   */
  public SortableBeerList(IbuComparator ibuC) {
    // TODO Auto-generated constructor stub
  }
  
  /**SortableBeerList.
   * 
   * @param abvC abvC
   */
  public SortableBeerList(AbvComparator abvC) {
    // TODO Auto-generated constructor stub
  }
  
  /** declares SortableBeerList method.
   *  @param index index
   * @return (Beer)
   */
  public Beer get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode<E> node = getNode(index);
    return node.data;
  }
  
  private DLinkedNode<E> getNode(int index) {
    // TODO Auto-generated method stub
    return null;
  }
 

  /**
   * Sets the item at the given index.
   * @param index the index.
   * @param element the new element to set.
   * @return the old element at index.
   */
  public Beer set(int index, Beer element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode<E> node = getNode(index);
    Beer old = node.data;
    node.data = element;
    return old;
  }

  /**
   * Returns the index of the given obj or -1.
   * @param obj the object to find.
   * @return the index of the given obj or -1.
   */
  public int indexOf(Object obj) {
    DLinkedNode<E> temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.data.equals(obj)) {
        return i;
      }
      temp = temp.next;
    }
    return - 1;
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