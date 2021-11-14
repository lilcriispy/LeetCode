import java.util.Arrays;

class RomanToInteger {
  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    String testing = "III";
    int expected = 3;
    var result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    testing = "IV";
    expected = 4;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    testing = "IX";
    expected = 9;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    testing = "LVIII";
    expected = 58;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    testing = "MCMXCIV";
    expected = 1994;
    result = process(testing);
    if(result != expected) {
      System.out.println("- Expected: " + expected + " -");
    }

    System.out.println("----------------------------------------\nElapsed time: " + (System.currentTimeMillis() - startTime) + " ms");
  }

  public static int process(String input) {
    System.out.println("\nInput: XXXX = " + input);
    int solution = Solution.romanToInt(input);
    System.out.println("Output: " + solution);
    return solution;
  }

  static class Solution { // make sure to remove the statics!
    public static int romanToInt(String s) {
      int[] values = { 1000, 500, 100, 50, 10, 5, 1 };
      int value = 0;
      int previousCharIndex = 0;

      for (char numeral : s.toCharArray()) {
        int charIndex = switch (numeral) {
          case 'M' -> 0;
          case 'D' -> 1;
          case 'C' -> 2;
          case 'L' -> 3;
          case 'X' -> 4;
          case 'V' -> 5;
          case 'I' -> 6;
          default -> throw new IllegalStateException("Unexpected value: " + numeral);
        };

        if (previousCharIndex > charIndex) { // values decrease as index increases
          value += values[charIndex] - (2 * values[previousCharIndex]);
        } else {
          value += values[charIndex];
        }

        previousCharIndex = charIndex;
      }

      return value;
    }
  }
}
