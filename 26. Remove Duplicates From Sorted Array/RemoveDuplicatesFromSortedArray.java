import java.util.Arrays;

class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    int[] testing = new int[]{ 1,1,2 };
    int expected = 2;
    int result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    } // might need a little extra asserting to make sure the array is correct

    testing = new int[]{ 0,0,1,1,1,2,2,3,3,4 };
    expected = 5;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static int process(int[] input) {
    System.out.println("\nInput: nums = " + Arrays.toString(input));
    int solution = Solution.removeDuplicates(input);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!
    public static int removeDuplicates(int[] nums) {
      if (nums.length <= 1) {
        return nums.length;
      } else {
        int lastPlace = 0;

        for (int i = 1; i < nums.length; i++) {
          if (nums[i] != nums[lastPlace]) {
            lastPlace++;
            nums[lastPlace] = nums[i];
          }
        }

        return lastPlace + 1;
      }
    }
  }
}
