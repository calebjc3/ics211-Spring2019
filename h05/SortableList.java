package edu.ics211.h05;

import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortableList;
import java.util.Comparator;


/**
 * Creates a Doubly Linked List.
 * 
 * @author Caleb Cheshire, Copyright 2019
 * 
 *      Received clarification from Christian Cheshire
 *
 * @param <E> E
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  private DLinkedNode<E> head;
  private DLinkedNode<E> tail;
  private int size;

  /** 
   * Constructor.
   */
  public SortableList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /** DLinkedNode class.
   * 
   * @author caleb
   *
   * @param <E> E
   */

  public static class DLinkedNode<E> {
    private E data;
    private DLinkedNode<E> next;
    private DLinkedNode<E> prev;

    /**
     * Creates a node.
     * 
     * @param data the data at the node
     */
    private DLinkedNode(E data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }

    /**
     * Creates a node.
     */
    private DLinkedNode(E data, DLinkedNode<E> next, DLinkedNode<E> prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
  }

  /** checkIndex method.
   * @param index index
   */
  
  public void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
  }

  /**
   * The add(item) method adds an item to the list.
   */
  @Override
  public boolean add(E item) {
    add(size, item);
    return true;
  }

  /**
   * Adds an item at index.
   */
  @Override
  public void add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      addFirst(item);
    } else {
      DLinkedNode<E> node = getNode(index - 1);
      addAfter(node, item);
    }
  }

  /**
   * Helper method to add after another node.
   */
  private void addAfter(DLinkedNode<E> node, E item) {
    DLinkedNode<E> temp = new DLinkedNode<E>(item, node.next, node);
    node.next = temp;
    node.next.prev = temp;
    size++;
  }

  /**
   * Helper method to add at the beginning of the list.
   * Received clarification on this method from Tallas Goo
   * @param item the item to be added
   */
  private void addFirst(E item) {
    head = new DLinkedNode<E>(item, tail, head);
    size++;
  }

  /**
   * Removes element at index.
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode<E> node = getNode(index);
    return remove(node);    
  }

  /**
   * Helper method for remove.
   * @param node the node
   * @return returns the data at the node
   */
  private E remove(DLinkedNode<E> node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    size--;
    return node.data;
  }

  /**
   * Gets the data at index.
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode<E> node = getNode(index);
    return node.data;
  }

  /**
   * Helper method to get a node.
   * @param index the index of the list
   * @return node
   */
  private DLinkedNode<E> getNode(int index) {
    DLinkedNode<E> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  /**
   * Sets an element at position index.
   */
  @Override
  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode<E> node = getNode(index);
    E old = node.data;
    node.data = element;
    return old;
  }

  /**
   * The size of the list.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Sorts using the insertion method.
   */
  @Override
  public void insertionSort(Comparator<E> compare) {

    for (int i = 1; i < size; i ++) {
      E nextVal = getNode(i).data;

      /* Received clarification from Christian Cheshire on how to do this */
      while (i > 0 && compare.compare(getNode(i - 1).data, nextVal) > 0) {
        getNode(i).data = getNode(i - 1).data;
        i--;
      }
      getNode(i).data = nextVal;
    }   
  }

  /**
   * Sorts using the bubble method.
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {

    boolean exchange = false;
    do {
      exchange = false;
      for (int i = 1; i < size; i++) {
        int result = compare.compare(getNode(i - 1).data, getNode(i).data);

        if (result > 0) {
          E temp = getNode(i).data;
          getNode(i).data = getNode(i - 1).data;
          getNode(i - 1).data = temp;
          exchange = true;
        }
      }
    } while (exchange);

  }

  /**
   * Sorts using the selection method.
   */
  @Override
  public void selectionSort(Comparator<E> compare) {

    for (int i = 0; i < size - 1; i++) {
      int posMin = i;

      for (int j = i + 1; j < size; j++) {
        int comp = compare.compare(getNode(posMin).data, getNode(j).data);

        if (comp > 0) {
          posMin = j;
        }
      }

      if (i != posMin) {
        E temp = getNode(i).data;
        getNode(i).data = getNode(posMin).data;
        getNode(posMin).data = temp;
      }
    }

  }

  @Override
  public int getNumberOfSwaps() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getSortTime() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
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
}