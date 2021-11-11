import java.util.Arrays;

class TEMPLATE {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    var testing = new var[]{  };
    var expected = ;
    var result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    testing = new var[]{  };
    expected = ;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static var process(var[] input) {
    System.out.println("\nInput: XXXX = " + Arrays.toString(input));
    var solution = Solution.XXXXX(input);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!

  }
}
