package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents a JUnit Test case for the package.
 *
 * @author Caleb Cheshire
 *     Got help from Prof. Moore's lectures and screencasts. 
 *     Also looked at his tests to help me build my test class.
 */
public class MyTestClass {

  /* My testing strategy is very similar to the strategy used by Prof. Moore.
   * I provided sample contacts to the program and the test made sure 
   *   that the program could compare and sort the contacts.
   * A successful test would show that the comparator and BinarySearchTree work, 
   *   while a failed test would show that there is an error.
   * Basically, the strategy is to provide information for the program to compare and sort.
   * 
   */
  
  /**
   * Test method for Compare.
   */
  @Test
  public void testCompare() {
    ContactComparator c = new ContactComparator();
    
    Contact bar = new Contact("Bar", "Foo", "808-555-2345");
    Contact foo = new Contact("Foo", "Bar", "808-555-1234");
    Contact baz = new Contact("Baz", "Foo", "808-555-3456");
    
    assertTrue(c.compare(foo, bar) < 0);
    assertEquals(c.compare(baz, baz), 0);
    assertTrue(c.compare(baz, bar) > 0);
  }
  
  private BinarySearchTree<Contact> tree;
  
  /**
   * Sets up the binary search tree.
   */
  @Before
  public void setUp() {
    this.tree = new BinarySearchTree<Contact>(new ContactComparator());
    tree.add(new Contact("Foo", "Moore", "808-555-1234"));
    tree.add(new Contact("Bar", "Foo", "898-555-2345"));
    tree.add(new Contact("Baz", "Foo", "808-555-3456"));
    tree.add(new Contact("Sir", "William", "123456"));
    tree.add(new Contact("Sir", "Stephen", "123957"));
    tree.add(new Contact("Sir", "Arthur", "123458"));
    tree.add(new Contact("Sir", "Matilda", "123459"));
    tree.add(new Contact("Sir", "Geoffrey", "123460"));
  }

  /**
   * Test method for Contains.
   */
  @Test
  public void testContains() {
    assertTrue(tree.contains(new Contact("Sir", "William", "123456")));
    assertFalse(tree.contains(new Contact("Sir", "William I", "123456")));
  }

  /**
   * Test method for Find.
   */
  @Test
  public void testFind() {
    Contact m = new Contact("Sir", "Matilda", "123459");
    assertEquals(m, tree.find(m));
    assertEquals(null, tree.find(new Contact("asd", "djg", "2")));
  }

  /**
   * Test method for Delete.
   */
  @Test
  public void testDelete() {
    Contact m = new Contact("Sir", "Matilda", "123459");
    assertEquals(m, tree.delete(m));
    assertEquals(null, tree.delete(m));
  }

  /**
   * Test method for Remove.
   */
  @Test
  public void testRemove() {
    Contact m = new Contact("Sir", "Matilda", "123459");
    assertTrue(tree.remove(m));
    assertFalse(tree.remove(m));
  }

  /**
   * Test method for Inorder.
   */
  @Test
  public void testInorder() {
    List<Contact> contacts = tree.inorder();
    assertNotNull(contacts);
    assertEquals(contacts.size(), 8);
    assertTrue(contacts.get(0).equals(new Contact("Sir", "Arthur", "123458")));
    assertTrue(contacts.get(7).equals(new Contact("Sir", "William", "123456")));
    assertTrue(contacts.get(5).equals(new Contact("Foo", "Moore", "808-555-1234")));
  }
}