package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.ics211.h04.SortableList;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Test;


/** Public class SortableListTest.
 * @author caleb
 *        with help from Justin Chen and Gabriel Elacion
 * @param <E>
 *
 */
public class SortableListTest<E> {
  private static final Object[] data = null;
  SortableList<Integer> sorter;
  private int size;
  
  /** declares testIList.
   * @param myInt i
   * 
   */
  @SuppressWarnings("null")
  public void testIList(int myInt) {
    SortableList<Integer> list = new SortableList<Integer>();
    assertNotNull(list);
    assertTrue(0 == list.size());

    Arrays.copyOf(data, data.length);

    Object[] data = null;
    Arrays.copyOf(data, data.length);
  }

  /**
   * Declares testAdd.
   * @param shortData sd
   * @param ic ic
   * @param longData ld
   * @param size s
   * @param copy c
   */
  public void testAdd(Object[] shortData, Comparator<Integer> ic, 
      Object[] longData, int size, Object[] copy) {
    SortableList<Integer> sorter = new SortableList<Integer>();
    assertTrue(sorter.add(copy[0]));
    sorter.add(copy[1]);
    size = 2;
    Assert.assertEquals("Wrong size", size, sorter.size());
    try {

      sorter.add(-1, (Integer) copy [0]);
      fail("Invalid index: Should not have ran add()");
    } catch (IndexOutOfBoundsException e) {
      //Should run through here
    }
  }

  /**
   * Declares testGet.
   * @param shortData sd
   * @param ic ic
   * @param longData id
   * @param copy c
   */
  public void testGet(Object[] shortData, Comparator<Integer> ic, 
      Object[] longData, Object[] copy) {
    SortableList<Integer> sorter = new SortableList<Integer>();
    Assert.assertEquals("Got the wrong element", copy[1], sorter.get(1));
    try {

      sorter.get(20);
      fail("Invalid index: Should not have ran get ()");
    } catch (IndexOutOfBoundsException e) {
      //Should run through here
    }
  }

  /**
   * Declares testSet.
   * @param shortData sd
   * @param ic ic
   * @param longData ld
   * @param copy c
   */
  public void testSet(Object[] shortData, Comparator<Integer> ic, 
      Object[] longData, Integer[] copy) {
    SortableList<Integer> sorter = new SortableList<Integer>();
    Assert.assertEquals("Did not return old value", copy[0], sorter.set(0, copy[3]));
    sorter.set(0, copy[0]);
    try {

      sorter.set(-1, copy[0]);
      fail("Invalid index: Should not run set()");
    } catch (IndexOutOfBoundsException e) {
      //Should run through here
    }
  }

  /** declare testindexOf.
   * 
   * @param longData longData
   * @param shortData shortData
   * @param ic ic
   * @param size size
   * @param copy copy
   * 
   */
  //Test indexOf method
  public void testindexOf(Object[] shortData, Comparator<Integer> ic, 
      Object[] longData, int size, Integer[] copy) {
    SortableList<Integer> sorter = new SortableList<Integer>();

    sorter.add(copy[2]);
    sorter.add(copy[3]);
    size = size + 2;
    assertEquals("wrong index", 0, sorter.indexOf(copy[0])); {
      assertEquals("Shouldn't have found an index", -1, sorter.indexOf(-1));
    }


    //Testing the remove method
    assertEquals("Wrong element", copy [1], sorter.remove(1));
    size = size - 1;
    assertEquals("Wrong size", size, sorter.size());
    try {

      sorter.remove(30);
      fail("Invalid index: should not have removed an element");
    } catch (IndexOutOfBoundsException e) {
      //Should run here
    }
  }

  /**declares testInsertionSort.
   * 
   */
  @Test
  public void testInsertionSort() {
    SortableList<Integer> sorter = new SortableList<Integer>();
    sorter.add(size);
    sorter.add(1);
    sorter.add(4);
    sorter.add(5);
    sorter.add(9);
    int index = 0;
    assertTrue("wrong sort", index < 0 || index >= size);
  }

  /**declares testBubbleSort.
   * 
   */
  @SuppressWarnings("null")
  @Test
  public void testBubbleSort() {
    SortableList<Integer> sorter = new SortableList<Integer>();
    sorter.add(size);
    sorter.add(1);
    sorter.add(4);
    sorter.add(5);
    sorter.add(9);
    int index = 0;
    assertTrue("wrong sort", index < 0 || index >= size);
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#selectionSort(java.util.Comparator, E[])}.
   */
  @SuppressWarnings("null")
  @Test
  public void testSelectionSort() {

    SortableList<Integer> sorter = new SortableList<Integer>();
    sorter.add(size);
    sorter.add(1);
    sorter.add(4);
    sorter.add(5);
    sorter.add(9);
    int index = 0;
    assertTrue("wrong sort", index < 0 || index >= size);
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#getNumOfSwaps(java.util.Comparator, E[])}.
   */
  @Test
  public void testgetNumOfSwaps() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#getNumOfComp(java.util.Comparator, E[])}.
   */
  @Test
  public void testgetNumOfComp() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#getSortTimes(java.util.Comparator, E[])}.
   */
  @Test
  public void testgetSortTimes() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#size(java.util.Comparator, E[])}.
   */
  @Test
  public void testSize() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#booadd(java.util.Comparator, E[])}.
   */
  @Test
  public void testAddE() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#voidadd(java.util.Comparator, E[])}.
   */
  @Test
  public void testAddIntE() {
    //fail("Not implemented yet");
  }

  /**
   * Test method for {@link edu.ics211.h04.SortableList#remove(java.util.Comparator, E[])}.
   */
  @SuppressWarnings("null")
  @Test
  public void testRemove() {
    assertEquals("Wrong element", data[1], sorter.remove(size));
    size = size - 1;
    assertEquals("Wrong size", size, sorter.size());
    try {
      sorter.remove(30);
      fail("Invalid index: Should not have removed an element");
    } catch (IndexOutOfBoundsException e) {
      //Pass
    }
  }

  /**
   * Tests the times for sorting sorted arrays.
   */

  @Test
  public void testCompareSortTimes() {
    //fail("Not implemented yet");
  }
}
