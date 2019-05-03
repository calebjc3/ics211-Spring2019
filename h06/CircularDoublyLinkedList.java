package edu.ics211.h06;

import edu.ics211.h04.IList211;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Declares a class CircularDoublyLinkedList.
 * 
 * @author Caleb Cheshire
 *        with assistance from Christian Cheshire and Gabriel Elacion
 * @param <E> The type of list.
 *
 */
public class CircularDoublyLinkedList<E> implements IList211<E>, Iterable<E> {
  /**
   * Declares class DLinkedNode.
   * 
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
    
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }
  
  /**
   * Declares an Iterator for Circular Doubly Linked List.
   *
   *
   */
  private class CircularDoublyLinkedListIterator implements ListIterator<E> {   
    private DLinkedNode currentNode;
    private DLinkedNode lastNodeReturned;
    private int nextIndex;
    private int prevIndex;
    private boolean checkRemove;
    
    public CircularDoublyLinkedListIterator() {        
      currentNode = head;
      lastNodeReturned = null;
      checkRemove = false;
      nextIndex = -1;
      prevIndex = 0;
    }
    
    @Override
    public void add(E arg0) {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean hasNext() {
      return size > 0;
    }

    @Override
    public boolean hasPrevious() {
      return size > 0;
    }

    @Override
    public E next() {      
      if (checkRemove == false) {
        checkRemove = true;
      }     
      lastNodeReturned = currentNode;
      currentNode = currentNode.next;
      E item = lastNodeReturned.item;      
      nextIndex = (nextIndex + 1) % size; 
      prevIndex = ((prevIndex - 1) + size) % size;     
      return item;
    }

    @Override
    public int nextIndex() {     
      return (nextIndex + 1) % size;
    }

    @Override
    public E previous() {
      if (checkRemove == false) {
        checkRemove = true;
      }     
      lastNodeReturned = currentNode.prev;      
      currentNode = currentNode.prev;          
      E item = lastNodeReturned.item;     
      nextIndex = (nextIndex + 1) % size; 
      prevIndex = ((prevIndex - 1) + size) % size;     
      return item;
    }

    @Override
    public int previousIndex() {      
      return ((prevIndex - 1) + size) % size;
    }

    @Override
    public void remove() {
      if (checkRemove = true) {             
        if (lastNodeReturned == null) {
          throw new NoSuchElementException();
        }      
        if (size == 1) {
          head = null;
          tail = null;
        }        
        if (lastNodeReturned == head) {
          head = currentNode.next;
          head.prev = tail;
        } else if (lastNodeReturned == tail) {
          tail = tail.prev;
          tail.next = head;
        } else {
          DLinkedNode prevNode = lastNodeReturned.prev;
          DLinkedNode nextNode = lastNodeReturned.next;      
          prevNode.next = nextNode;
          nextNode.prev = prevNode;
        }        
        size = size - 1;
        checkRemove = false;
      } else {
        throw new IllegalStateException();
      }
    }

    @Override
    public void set(E arg0) {
      throw new UnsupportedOperationException();
    }
  }
  
  DLinkedNode head;
  DLinkedNode tail;  
  private int size;
  
  /**
   * Creates a new Circular Doubly Linked List.
   */
  public CircularDoublyLinkedList() {   
    head = null;
    tail = null;   
    size = 0;
  }
  
  /**
   * Declares a new Circular Doubly Linked List.
   * 
   * @param items the array of data.
   */
  public CircularDoublyLinkedList(E[] items) {  
    this();
    for (E item: items) {
      add(item);
    }
  }
  
  private void checkIndex(int index) {   
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  @Override
  public Iterator<E> iterator() { 
    CircularDoublyLinkedListIterator iterator = new CircularDoublyLinkedListIterator();
    return iterator;
  }

  @Override
  public E get(int index) {   
    checkIndex(index);
    DLinkedNode node = head;
    if (index != size) {
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
    }
    return node.item;
  }

  @Override
  public E set(int index, E element) {   
    checkIndex(index);  
    DLinkedNode node = head;
    E oldElement;    
    if (index == 0) {      
      oldElement = node.item;
      node.item = element;
      return oldElement;
    }       
    for (int i = 0; i < index; i++) {     
      node = node.next;
    }  
    oldElement = node.item;
    node.item = element; 
    return oldElement;
  }

  @Override
  public int indexOf(Object obj) { 
    if (obj == null) {   
      return -1;
    }
    DLinkedNode current = head;
    E element;
    for (int i = 0; i < size; i++) {
      if (current.item != null) {
        element = current.item;
        if (element.equals(obj) == true) {
          return i;
        }
      }
      current = current.next;
    }
    return -1;
  }
  
  @Override
  public int size() {
    return size;
  }

  //Found this method code at: https://codereview.stackexchange.com/questions/122535/java-doubly-linked-list-implementation
  private void addBefore(E element) {
    DLinkedNode newNode = new DLinkedNode(element, null, null);
    if (head == null) {   
      head = newNode;
      tail = newNode;     
      newNode.next = newNode;
      newNode.prev = newNode;
    } else {      
      newNode.next = head;
      head.prev = newNode;
      head = newNode;      
      head.prev = tail;
      tail.next = head;
    }   
    size = size + 1;
  }
  
  @Override
  public boolean add(E e) {
    DLinkedNode newNode = new DLinkedNode(e, null, null);   
    if (head == null) {    
      head = newNode;
      tail = newNode;     
      newNode.next = newNode;
      newNode.prev = newNode;
    } else {    
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;     
      newNode.next = head;
      head.prev = newNode;
    }   
    size = size + 1;
    return true;
  }

  @Override
  public void add(int index, E element) { 
    checkIndex(index);
    DLinkedNode current = head;
    DLinkedNode newNode = new DLinkedNode(element, null, null);
    if (index == 0) {
      addBefore(element);
    } else if (index == size) {
      add(element);
    } else {
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      DLinkedNode prev = current.prev;
      newNode.prev = prev;
      prev.next = newNode;
      newNode.next = current;
      current.prev = newNode;   
      size = size + 1;
    }    
  }

  @Override
  public E remove(int index) {    
    checkIndex(index);
    DLinkedNode current = head;
    if (index == 0) {
      DLinkedNode newHead = current.next;
      head = newHead;
      head.prev = newHead;
      head.next = newHead;
      size = size - 1;
      return current.item;
    } else if (index == (size - 1)) {
      size = size - 1;
      tail.next = head;
      head.prev = tail;
      DLinkedNode oldTail = tail;
      tail = tail.prev;
      return oldTail.item;
    }
    for (int i = 0; i < index; i++) {      
      current = current.next;
    }   
    DLinkedNode prev = current.prev;
    DLinkedNode next = current.next;
    prev.next = next;
    next.prev = prev;   
    size = size - 1;
    return current.item;
  }
}