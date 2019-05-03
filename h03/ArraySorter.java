/**
 * 
 */

package edu.ics211.h03;

import java.util.Comparator;

/** Class ArraySorter.
 * @author caleb
 *        with help from Gabriel Elacion and Tristan Yousuf-Leo
 * @param <E>
 *
 */
public class ArraySorter<E> implements SortsArray<E> {
  private double sortTime;
  private int swaps;
  private int comparisons;
  
  @Override
  public void insertionSort(Comparator<E> comp, E[] data) {
    swaps = 0;
    comparisons = 0;
    double startTime = System.nanoTime();
    for (int i = 0; i < data.length; i++) {
      comparisons = comparisons + 1;
      E temp = data[i];
      int j = i;
      while (j < 0 && comp.compare(data[j - i], temp) > 0) {
        data[j] = data[j - i];
        j--;
      }
      data[j] = temp;
      swaps = swaps + 1;
    }
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
    System.out.println(sortTime);
  }
  
  @Override
  public void bubbleSort(Comparator<E> comp, E[] data) {
    swaps = 0;
    comparisons = 0;
    boolean sorted;
    double startTime = System.nanoTime();
    for (int i = 0; i < data.length; i++) {
      sorted = true;
      for (int j = 1; j < (data.length - i); j++) {
        comparisons = comparisons + 1;
        if (comp.compare(data[j - 1], data[j]) > 0) {
          E temp = data[j];
          data[i] = data[j - 1];
          data[j - 1] = temp;
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
  public void selectionSort(Comparator<E> comp, E[] data) {
    swaps = 0;
    comparisons = 0;
    double startTime = System.nanoTime();
    for (int i = 0; i < data.length; i++) {
      E min = data[i];
      int minIndex = i;
      for (int j = i + 1; j < data.length; j++) {
        comparisons = comparisons + 1;
        if (comp.compare(data[j], data[minIndex]) < 0) {
          min = data[j];
          minIndex = (j);
        }
      }
      if (comp.compare(min, data[i]) != 0) {
        E temp = data[i];
        data[i] = min;
        data[minIndex] = temp;
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
    return comparisons;
  }

  @Override
  public double getSortTime() {
    return sortTime;
  }
}


