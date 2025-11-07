package src.org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A class that models a set of integers using ArrayList. 
 * Supports standard set operations (union, intersection, etc.)
 */
public class IntegerSet  {
  private List<Integer> set = new ArrayList<Integer>();

  /**
   * Clears all elements from the set.
   */
  public void clear() {this.set.clear();}

  /**
   * Returns the number of element sin the set
   * @return number of elements in set
   */ 
  public int length() { return this.set.size(); }

 /**
  * Compares this set to another object for equality. 
  * Two sets are equal if they contain the same elements, independent of order. 
  * @param o the object being compared against
  * @return true if both sets contain the same integers
  */
  @Override
  public boolean equals(Object o) { 
    if(!(o instanceof IntegerSet)) return false; 

    IntegerSet other = (IntegerSet) o; 
    return this.set.containsAll(other.set) && other.set.containsAll(set);
  }

  /**
   * Checks if the set contains a given value
   * @param value the integer to look for
   * @return true if value exists in set
   */
  public boolean contains(int value) { return this.set.contains(value); }

  /**
   * Returns the largest integer in the set
   * @return largest integer
   * @throws IllegalStateException if set is empty
   */  
  public int largest()  { 
    if(this.set.isEmpty()){throw new IllegalStateException("Cannot perform action, set is empty");}
    return Collections.max(set);
  }

  /**
   * Returns the smallest item in the set 
   * @throws IllegalStateException if empty
   */
  public int smallest()  { 
    if(this.set.isEmpty()){throw new IllegalStateException("Cannot perform action, set is empty");}
    return Collections.min(set);
  }

  /**
   * Adds an item to the set, if not already present.
   * @param item integer to add
   */
  public void add(int item) { 
    if(!this.set.contains(item)){set.add(item);}
   }

  /**
   * Removes an integer from the set if present.
   * @param item integer to remove
   */
  public void remove(int item) {
    this.set.remove(Integer.valueOf(item));
  }

  /**
   * Modifies this set to include all elements from both sets (union).
   * @param other another IntegerSet
   */
  public void union(IntegerSet other) {
    for (int num : other.set) {
      if (!this.set.contains(num)) {
        this.set.add(num);
      }
    }
  }

  /**
   * Modifies this set to contain only elements present in both sets (intersection).
   * @param other another IntegerSet
   */
  public void intersect(IntegerSet other) {
    this.set.retainAll(other.set);
  }

  /**
   * Removes all elements that are also contained in another set (difference).
   * @param other another IntegerSet
   */
  public void diff(IntegerSet other) {
    this.set.removeAll(other.set);
  }

  /**
   * Modifies this set to become the complement: (other \ this).
   * @param other another IntegerSet
   */
  public void complement(IntegerSet other) {
    List<Integer> newSet = new ArrayList<Integer>(other.set);
    newSet.removeAll(this.set);
    this.set = newSet;
  }

  /**
   * Checks if the set is empty.
   * @return true if no elements exist
   */
  public boolean isEmpty() {
    return this.set.isEmpty();
  }

  /**
   * Returns a string representation of the set.
   * @return formatted string such as [1, 2, 3]
   */
  @Override
  public String toString() {
    return this.set.toString();
  }
}