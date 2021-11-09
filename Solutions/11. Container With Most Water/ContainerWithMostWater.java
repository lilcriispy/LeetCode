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
      int left = 0;
      int right = height.length - 1;

      while (left < right) {
        if (height[left] < height [right]) {
          if ((right - left) * height[left] > maxFill) { maxFill = (right - left) * height[left]; }
          left++;
        } else {
          if ((right - left) * height[right] > maxFill) { maxFill = (right - left) * height[right]; }
          right--;
        }
      }

      return maxFill;
    }
  }
}
