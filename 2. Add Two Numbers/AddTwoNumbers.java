import static java.util.Arrays.compare;

import java.util.Arrays;

class AddTwoNumbers {

  public static void main(String[] args) {
    System.out.print("----------------------------------------");
    long startTime = System.currentTimeMillis();

    int[] ints1 = new int[]{2, 4, 3}; // there's definitely a better way to do testing for this
    int[] ints2 = new int[]{5, 6, 4};
    ListNode testing1 = fromArray(ints1);
    ListNode testing2 = fromArray(ints2);

    int[] expected = new int[]{7, 0, 8};
    int[] result = process(testing1, testing2);
    if (compare(result, expected) != 0) {
      System.out.println("- Expected: " + Arrays.toString(expected) + " -");
    }

    testing1 = new ListNode(0);
    testing2 = new ListNode(0);

    expected = new int[]{0};
    result = process(testing1, testing2);
    if (compare(result, expected) != 0) {
      System.out.println("- Expected: " + Arrays.toString(expected) + " -");
    }

    ints1 = new int[]{9, 9, 9, 9, 9, 9, 9};
    ints2 = new int[]{9, 9, 9, 9};
    testing1 = fromArray(ints1);
    testing2 = fromArray(ints2);

    expected = new int[]{8, 9, 9, 9, 0, 0, 0, 1};
    result = process(testing1, testing2);
    if (compare(result, expected) != 0) {
      System.out.println("- Expected: " + Arrays.toString(expected) + " -");
    }

    System.out.println(
        "----------------------------------------\nElapsed time: " + (System.currentTimeMillis()
            - startTime) + " ms");
  }

  public static int[] process(ListNode node1, ListNode node2) {
    System.out.println(
        "\nInput: l1 = " + Arrays.toString(node1.toArray()) + ", l2 = " + Arrays.toString(
            node2.toArray()));
    ListNode solution = Solution.addTwoNumbers(node1, node2);
    int[] solutionArray = solution.toArray();
    System.out.println("Output: " + Arrays.toString(solutionArray));
    return solutionArray;
  }

  public static ListNode fromArray(int[] arr) {
    ListNode head = new ListNode(arr[0]);
    ListNode ref = head;

    for (int i = 1; i < arr.length; i++) {
      ref.next = new ListNode(arr[i]);
      ref = ref.next;
    }

    return head;
  }


  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    int[] toArray() {
      if (this == null) {
        return new int[0];
      }
      else if (next != null) {
        int[] nextInts = this.next.toArray();
        int[] toReturn = new int[nextInts.length + 1];

        toReturn[0] = this.val;
        for (int i = 0; i < nextInts.length; i++) {
          toReturn[i + 1] = nextInts[i];
        }

        return toReturn;
      } else {
        return new int[]{this.val};
      }
    }
  }

  static class Solution { // make sure to remove the statics!

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 != null && l2 != null) {
        int sum = l1.val + l2.val;
        if (sum < 10) {
          l1.val = sum;
        } else {
          l1.val = sum % 10;
          if (l1.next != null) {
            l1.next.val += 1;
          } else if (l2.next != null){ // switch tracks if available
            l2.next.val += 1;
            l1.next = l2.next;
            l2.next = null;
          } else {
            l1.next = new ListNode(1);
          }
        }

        l1.next = addTwoNumbers(l1.next, l2.next);
        return l1;
      } else if (l1 == null && l2 != null) {
        if (l2.val >= 10) {
          if (l2.next == null) {
            l2.next = new ListNode(1);
          } else {
            l2.next.val += 1;
          }
          l2.val %= 10;
          l2.next = addTwoNumbers(null, l2.next); // to propagate 'carry the 1's up the line
        }
        return l2;
      } else if (l1 != null) {
        if (l1.val >= 10) {
          if (l1.next == null) {
            l1.next = new ListNode(1);
          } else {
            l1.next.val += 1;
          }
          l1.val %= 10;
          l1.next = addTwoNumbers(l1.next, null); // to propagate 'carry the 1's up the line
        }
        return l1;
      } else {
        return null;
      }
    }
  }
}
