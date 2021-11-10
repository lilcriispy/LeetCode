import java.util.ArrayList;
import java.util.Arrays;

class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    String[] testing = new String[]{ "flower","flow","flight" };
    String expected = "fl";
    String result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    testing = new String[]{ "dog","racecar","car" };
    expected = "";
    result = process(testing);
    assert result != expected : "- Expected: " + expected + " -";

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static String process(String[] input) {
    System.out.println("\nInput: height = " + Arrays.toString(input));
    String solution = Solution.longestCommonPrefix(input);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!

    public static String longestCommonPrefix(String[] strs) {
      String common = strs[0];
      ArrayList<String> strings = new ArrayList<>();

      for (int i = 1; i < strs.length; i++) {
        strings.add(strs[i]);  // 1. (see commit message - not super important, just an explanation why I did it this way)
      }

      for (String word : strings) {
        if (common.equals("")) { return common; }

        for (int i = 0; i < word.length() && i < common.length(); i++) {
          if (common.charAt(i) != word.charAt(i)) {
            common = common.substring(0, i);
          }
        }

        if (common.length() > word.length()) {
          common = common.substring(0, word.length());
        }
      }

      return common;
    }
  }
}
