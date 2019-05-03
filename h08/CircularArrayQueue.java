package edu.ics211.h08;

import java.util.NoSuchElementException;

/**
 * Declares class CircularArrayQueue with param E.
 * @author Caleb Cheshire
 *         got the methods from Cam Moore/ICS211 Spring 2019/Queue ADT Screencast.
 *
 * @param <E> E
 */
public class CircularArrayQueue<E> implements Queue211<E> {

  //Creates the member variables of the class.
  private E[] data;
  private int front;
  private int rear;
  private int size;

  /**
   * Declares CircularArrayQueue constructor.
   * 
   */
  @SuppressWarnings("unchecked")
  public CircularArrayQueue() {
    this.data = (E[]) new Object[10];
    this.front = 0;
    this.rear = data.length - 1;
    this.size = 0;
  }
  
  private void reallocate() {
    @SuppressWarnings("unchecked")
    E [] newData = (E[]) new Object[2 * data.length];
    int b = front;
    for (int a = 0; a < size; a++) {
      newData[a] = data[b];
      b = (b + 1) % data.length;
    }
  }

  @Override
  public boolean add(E item) {
    //checks if the array is full
    if (size == data.length) {
      reallocate();
    }
    rear = (rear + 1) % data.length;
    data[rear] = item;
    size++;
    return true;  
  }

  @Override
  public E element() {
    //checks if the array is empty
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[front];
  }

  @Override
  public boolean offer(E item) {
    try {
      return add(item);
    } catch (IllegalStateException ise) {
      return false;
    }
  }

  @Override
  public E peek() {
    try {
      return element();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }

  @Override
  public E poll() {
    try {
      return remove();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }

  @Override
  public E remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E val = data[front];
    front = (front + 1) % data.length;
    size--;
    return val;
  }

  @Override
  public int size() {
    return size;
  }

}
