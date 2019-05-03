package edu.ics211.h10;

import java.util.Comparator;

/**Contact Comparator Class.
 * @author Caleb Cheshire
 *        got help from the textbook, Section 6.5
 *        found clarification on method structure from https://github.com/sjavella/ics211
 *
 */
public class ContactComparator implements Comparator<Contact> {
  //compare last name
  //if last names are the same
  //compare first name
  
  @Override
  public int compare(Contact o1, Contact o2) {
    if ((o1.getLastName()).compareTo(o2.getLastName()) != 0) { 
      return (o1.getLastName().compareTo(o2.getLastName()));
    } else {
      return (o1.getFirstName().compareTo(o2.getFirstName()));
    }
  }
}