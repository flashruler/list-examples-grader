import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

class Checker implements StringChecker {
  public boolean checkString(String s) {
    return s.contains("test");
  }
}

public class TestListExamples {
  // Write your grading tests here!
  StringChecker s = new Checker();

  @Test(timeout = 100)
  public void filter_test() {
    List<String> input = Arrays.asList(new String[] { "running", "test on", "redbull", "rn test" });
    List<String> expect = Arrays.asList(new String[] { "test on", "rn test" });
    List<String> result = ListExamples.filter(input, s);

    Assert.assertArrayEquals(expect.toArray(), result.toArray());
  }

  @Test(timeout = 100)
  public void filter_testDuplicates() {
    List<String> input = Arrays.asList(new String[] { "test", "test", "test", "test", "test" });
    List<String> expect = Arrays.asList(new String[] { "test", "test", "test", "test", "test" });
    List<String> result = ListExamples.filter(input, s);

    Assert.assertArrayEquals(expect.toArray(), result.toArray());
  }

  @Test(timeout = 100)
  public void filter_testEmpty() {
    List<String> input = Arrays.asList(new String[] {});
    List<String> expect = Arrays.asList(new String[] {});
    List<String> result = ListExamples.filter(input, s);

    Assert.assertArrayEquals(expect.toArray(), result.toArray());
  }

  @Test(timeout = 100)
  public void filter_testNoMatch() {
    List<String> input = Arrays.asList(new String[] { "leclerc", "verstappen", "hamilton", "vettel" });
    List<String> expect = Arrays.asList(new String[] {});
    List<String> result = ListExamples.filter(input, s);

    Assert.assertArrayEquals(expect.toArray(), result.toArray());
  }

  @Test(timeout = 100)
  public void testMerge() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    input1.add("a");
    input1.add("c");
    input2.add("b");
    input2.add("d");
    expected.add("a");
    expected.add("b");
    expected.add("c");
    expected.add("d");
    // ListExamples.merge(input1, input2);
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeDuplicate() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    input1.add("a");
    input1.add("c");
    input1.add("d");
    input2.add("a");
    input2.add("c");
    input2.add("d");
    expected.add("a");
    expected.add("a");
    expected.add("c");
    expected.add("c");
    expected.add("d");
    expected.add("d");
    // ListExamples.merge(input1, input2);
    assertEquals(expected, ListExamples.merge(input1, input2));
  }

  @Test(timeout = 100)
  public void testMergeEmpty() {
    List<String> input1 = new ArrayList<>();
    List<String> input2 = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    // ListExamples.merge(input1, input2);
    assertEquals(expected, ListExamples.merge(input1, input2));
  }
}
