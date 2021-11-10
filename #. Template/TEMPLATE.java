import java.util.Arrays;

class TEMPLATE {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    var testing = new var[]{  };
    var expected = ;
    var result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new var[]{  };
    expected = ;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static var process(var[] input) {
    System.out.println("\nInput: height = " + Arrays.toString(input));
    var solution = Solution.XXXXX(input);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!

  }
}
