package facebook;

import java.util.Arrays;

public class Sort0And1 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort2One(new int[] {1, 0, 0, 6, 0, 2, 4, 0, 3, 4})));
  }

  private static int[] sort2One(int[] arr) {
    int low = 0;
    int high = arr.length - 1;

    while (low < high) {
      while (low < high && arr[low] > 0) {
        low++;
      }
      while (low < high && arr[high] == 0) {
        high--;
      }
      if (arr[low] == 0 && arr[high] > 0) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
      }
    }
    return arr;
  }
}
