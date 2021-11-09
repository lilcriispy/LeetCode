import java.util.Arrays;

class ContainerWithMostWater {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    int[] testing = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    int expected = 49;
    int result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new int[]{1, 1};
    expected = 1;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new int[]{4, 3, 2, 1, 4};
    expected = 16;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new int[]{1, 2, 1};
    expected = 2;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static int process(int[] height) {
    System.out.println("\nInput: height = " + Arrays.toString(height));
    int solution = Solution.maxArea(height);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution {
    public static int maxArea(int[] height) { // make sure to remove the statics!
      int maxFill = 0;

      for (int i = 0; i < height.length; i++) {
        for (int j = i + 1; j < height.length; j++) {
          if (height[i] < height[j]) {
            if (height[i] * (j - i) > maxFill) { maxFill = height[i] * (j - i); }
          } else {
            if (height[j] * (j - i) > maxFill) { maxFill = height[j] * (j - i); }
          }
        }
      }

      return maxFill;
    }
  }
}
