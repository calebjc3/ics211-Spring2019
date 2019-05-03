/**
 * 
 */

package edu.ics211.h04;

import java.util.Arrays;
import java.util.Comparator;

/** Creates a class SortableList that implements IList211 and ISortableList.
 * @author caleb
 * @param <E>
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  //private static final int INITIAL_CAPACITY = 10;
  private E [] theData;
  private int size = 0;
  private int swaps;
  private double sortTime;
  private int comparisons;

  /** Creates method SortableList.
   * 
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    this.theData = (E[]) new Object[10];
    this.size = 0;
  }

  @Override
  public void insertionSort(Comparator<E> compare) {
    swaps = 0;
    comparisons = 0;
    double startTime = System.nanoTime();
    for (int i = 0; i < theData.length; i++) {
      comparisons = comparisons + 1;
      E temp = theData[i];
      int j = i;
      while (j < 0 && compare.compare(theData[j - i], temp) > 0) {
        theData[j] = theData[j - i];
        j--;
      }
      theData[j] = temp;
      swaps = swaps + 1;
    }
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
    System.out.println(sortTime);
  }

  @Override
  public void bubbleSort(Comparator<E> compare) {
    swaps = 0;
    comparisons = 0;
    boolean sorted;
    double startTime = System.nanoTime();
    for (int i = 0; i < theData.length; i++) {
      sorted = true;
      for (int j = 1; j < (theData.length - i); j++) {
        comparisons = comparisons + 1;
        if (compare.compare(theData[j - 1], theData[j]) > 0) {
          E temp = theData[j];
          theData[i] = theData[j - 1];
          theData[j - 1] = temp;
          swaps = swaps + 1;
          sorted = false;
        }
      }
      if (sorted == true) {
        break;
      }
    }
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
    System.out.println(sortTime);
  }

  @Override
  public void selectionSort(Comparator<E> compare) {
    swaps = 0;
    comparisons = 0;
    double startTime = System.nanoTime();
    for (int i = 0; i < theData.length; i++) {
      E min = theData[i];
      int minIndex = i;
      for (int j = i + 1; j < theData.length; j++) {
        comparisons = comparisons + 1;
        if (compare.compare(theData[j], theData[minIndex]) < 0) {
          min = theData[j];
          minIndex = (j);
        }
      }
      if (compare.compare(min, theData[i]) != 0) {
        E temp = theData[i];
        theData[i] = min;
        theData[minIndex] = temp;
        swaps = swaps + 1;
      }
    }
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
    System.out.println(sortTime);
  }

  @Override
  public int getNumberOfSwaps() {
    return 0;
  }

  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getSortTime() {
    return 0;
  }

  /**
   * Declares checkIndex.
   * @param index i
   */
  public void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
  }

  @Override
  public E get(int index) {
    checkIndex(index);
    return theData[index];
  }

  @Override
  public E set(int index, E element) {
    checkIndex(index);
    E old = theData[index];
    theData[index] = element;
    return old;
  }


  @Override
  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (theData[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean add(Object copy) {
    if (size == theData.length) {
      theData = Arrays.copyOf(theData, theData.length * 2);
    }
    theData[size] = (E) copy;
    size++;
    return true;
  }

  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index);
    }
    if (size == theData.length) {
      theData = Arrays.copyOf(theData, theData.length * 2);
    }
    for (int i = size; i > index; i--) {
      theData[i] = theData[i - 1];
    }
    theData[index] = element;
    size++;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    E returnValue = theData[index];
    for (int i = index + 1; i < size; i++) {
      theData[i - 1] = theData[i];
    }
    size--;
    return returnValue;
  }
}