package src.org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

  @Test
  public void testAddAndLength() {
    IntegerSet set = new IntegerSet();
    assertEquals(0, set.length());
    set.add(5);
    set.add(10);
    set.add(5); // duplicate
    assertEquals(2, set.length());
  }

  @Test
  public void testClearAndIsEmpty() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    set.clear();
    assertTrue(set.isEmpty());
  }

  @Test
  public void testContains() {
    IntegerSet set = new IntegerSet();
    set.add(3);
    assertTrue(set.contains(3));
    assertFalse(set.contains(5));
  }

  @Test
  public void testEquals() {
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();
    set1.add(1); set1.add(2);
    set2.add(2); set2.add(1);
    assertTrue(set1.equals(set2));

    set2.add(3);
    assertFalse(set1.equals(set2));
  }

  @Test
  public void testLargestAndSmallest() {
    IntegerSet set = new IntegerSet();
    set.add(2);
    set.add(8);
    set.add(5);
    assertEquals(8, set.largest());
    assertEquals(2, set.smallest());
  }

  @Test
  public void testLargestAndSmallestThrows() {
    IntegerSet set = new IntegerSet();
    assertThrows(IllegalStateException.class, () -> set.largest());
    assertThrows(IllegalStateException.class, () -> set.smallest());
  }

  @Test
  public void testRemove() {
    IntegerSet set = new IntegerSet();
    set.add(4);
    set.add(7);
    set.remove(4);
    assertFalse(set.contains(4));
    set.remove(100); // should not throw
    assertEquals(1, set.length());
  }

  @Test
  public void testUnion() {
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();
    set1.add(1); set1.add(2);
    set2.add(2); set2.add(3);
    set1.union(set2);
    assertTrue(set1.contains(1));
    assertTrue(set1.contains(2));
    assertTrue(set1.contains(3));
  }

  @Test
  public void testIntersect() {
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();
    set1.add(1); set1.add(2);
    set2.add(2); set2.add(3);
    set1.intersect(set2);
    assertEquals("[2]", set1.toString());
  }

  @Test
  public void testDiff() {
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();
    set1.add(1); set1.add(2); set1.add(3);
    set2.add(2);
    set1.diff(set2);
    assertEquals("[1, 3]", set1.toString());
  }

  @Test
  public void testComplement() {
    IntegerSet set1 = new IntegerSet();
    IntegerSet set2 = new IntegerSet();
    set1.add(1); set1.add(2);
    set2.add(2); set2.add(3);
    set1.complement(set2);
    assertEquals("[3]", set1.toString());
  }

  @Test
  public void testToStringFormat() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    set.add(2);
    assertEquals("[1, 2]", set.toString());
  }
}
