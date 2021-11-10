import java.util.Arrays;

class TEMPLATE {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    int[] testing = new int[]{  };
    int expected = ;
    int result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new int[]{  };
    expected = ;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static int process(int[] height) {
    System.out.println("\nInput: height = " + Arrays.toString(height));
    int solution = Solution.XXXXX(height);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!
    
  }
}
