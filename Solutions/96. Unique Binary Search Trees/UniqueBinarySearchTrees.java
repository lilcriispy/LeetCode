class Solution {
  public int numTrees(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else {
      int returning = 0;
      for (int i = 0; i < n / 2; i++) {
        returning += numTrees(i) * numTrees(n - 1 - i);
      }
      returning *= 2;

      if (n % 2 == 1) {
        int middle = numTrees(n / 2);
        returning += middle * middle;
      }

      return returning;
    }
  }
}
