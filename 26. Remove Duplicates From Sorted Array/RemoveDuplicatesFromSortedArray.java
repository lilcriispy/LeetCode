import java.util.Arrays;

class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    int[] testing = new int[]{ 1,1,2 };
    int expected = 2;
    int result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";
    // might need a little extra asserting to make sure the array is correct

    testing = new int[]{ 0,0,1,1,1,2,2,3,3,4 };
    expected = 5;
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

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
      if (nums.length == 0) {
        return nums.length;
      } else {
        int lastPlace = nums.length - 1;

        for (int i = lastPlace; i > 0; i--) {
          if (nums[i] == nums[i - 1]) {
            nums[i] = nums[lastPlace];
            for (int j = i; j < lastPlace; j++) {
              if (nums[j] > nums[j + 1]) {
                nums[lastPlace] = nums[j]; // using that spot to hold a temp number
                nums[j] = nums[j + 1];
                nums[j + 1] = nums[lastPlace];
              } else {
                j = lastPlace;
              }
            }
            lastPlace--;
          }
        }

        return lastPlace + 1;
      }
    }
  }
}
