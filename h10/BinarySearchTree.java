package edu.ics211.h10;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/** Declares public class BinarySearchTree with param E.
 * 
 * @author Caleb Cheshire
 *        found code for the methods from the textbook, Section 6.5
 *        also got help for some methods, runtime analysis, and 
 *        class structure from Prof. Moore's screencasts/lectures
 *        worked on some of the methods with Justin Chen
 * @param <E> a generic
 */
public class BinarySearchTree<E> implements SearchTree<E> {
  BinaryNode root;
  List<E> list = null;
  private Comparator<E> comp;

  /**
   * Inner node class.
   * 
   * @author Caleb Cheshire
   *        got help on the code from the textbook, Section 6.5, and help with the method structure and parameters from https://github.com/ejdingal/ICS211
   *
   */
  private class BinaryNode {
    E data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode() {
      this.data = null;
      this.left = null;
      this.right = null;
    }

    public BinaryNode(E data, BinaryNode left, BinaryNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * Declares new BinarySearchTree.
   * 
   * @param c the comparator.
   */
  public BinarySearchTree(Comparator<E> c) {
    this.root = new BinaryNode();
    this.comp = c;
  }

  @Override
  public boolean contains(E item) {
    if (find(item) == null) { 
      return false;
    }
    return true;
  }
  
  @Override
  public E find(E target) { 
    return find(target, root);
  }

  /**
   * Recursive find helper method.
   * 
   * @param target target
   * @param node node
   * @return E the node that was found
   */
  @SuppressWarnings("unchecked")
  public E find(E target, BinaryNode node) {
    if (node == null) { 
      return null;
    }
    if (comp.compare(target, (E) node.data) == 0) { 
      return node.data;
    }
    if (comp.compare(target, (E) node.data) < 0) { 
      return find(target, node.left);
    }
    if (comp.compare(target, (E) node.data) > 0) {
      return find(target, node.right);
    }
    return (E) node; 
  }
  
  @Override
  public boolean add(E item) { 
    return add(item, root);
  }

  /**
   * Recursive add helper method for add.
   * 
   * @param item item to be added
   * @param node root of tree or subtree to be added to
   * @return boolean successful addition of item
   */
  public boolean add(E item, BinaryNode node) {
    if (node.data == null) { 
      node.data = item;
      System.out.println("STORED");
      return true;
    }
    if (comp.compare(item, (E) node.data) < 0) { 
      if (node.left == null) { 
        node.left = new BinaryNode(); 
      }
      return add(item, node.left); 
    }
    if (comp.compare(item, (E) node.data) > 0) { 
      if (node.right == null) { 
        node.right = new BinaryNode(); 
      }
      return add(item, node.right); 
    }
    return false; 
  }

  @Override
  public E delete(E target) {
    return delete(target, root); 
  }

  /**
   * Recursive delete helper for delete, recursively finds target to delete.
   * 
   * @param target the target to be deleted
   * @param node the current node being looked at
   * @return E the node deleted
   */
  public E delete(E target, BinaryNode node) {
    if (node == null) { // no tree or reached end of branch, no node
      return null;
    }
    int comparison = comp.compare(target, (E) node.data);

    if (comparison < 0) { 
      return delete(target, node.left);
    } else if (comparison > 0) { 
      return delete(target, node.right);
    } else { 
      if (node.left == null && node.right == null) { 
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right);
        node = null;
        return (E) temp.data; 
      }
      if (node.left == null && node.right != null) {
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); 
        node.data = node.right.data;
        return (E) temp.data; 
      }
      if (node.left != null && node.right == null) {
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right);
        node.data = node.left.data;
        return (E) temp.data;
      }
      {
        BinaryNode farthest = node.left;
        while (farthest.right != null) {
          farthest = farthest.right;
        }
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right);
        node.data = farthest.data;
        node.left = null;
        return (E) temp.data;
      }
    }
  }

  @Override
  public boolean remove(E target) {
    if (delete(target) == null) {
      return false;
    }
    return true;
  }
  
  /**
   * Creates an in order list of the binary tree.
   * 
   * @return the items in order as a List.
   */
  public List<E> inorder() {
    list = new LinkedList<E>();
    return inorder(list, root);
  }

  /**
   * Recursive helper method.
   * 
   * @param list node list.
   * @param node the current node.
   * @return the ordered list of nodes.
   */
  private List<E> inorder(List<E> list, BinaryNode node) {

    if (node == null) { 
      return list;
    }
    inorder(list, node.left); 
    if (node != null) { 
      list.add((E) node.data); 
    }
    inorder(list, node.right); 
    return list; 
  }
}