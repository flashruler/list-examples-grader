import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import org.junit.Test;

public class TestListExamples {
  // Write your grading tests here!
  @Test
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
}


