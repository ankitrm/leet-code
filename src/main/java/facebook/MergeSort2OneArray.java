package facebook;

import java.util.Arrays;

public class MergeSort2OneArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort2One(new int[] {1, 3, 5, 6, 9, -1, -1, -1, -1, -1}, new int[] {2, 4, 7, 8, 10})));
  }

  private static int[] sort2One(int[] arr1, int[] arr2) {
    int idxLast = arr1.length - 1;
    int positiveArr1 = arr2.length - 1;
    int lastArr2 = arr2.length - 1;

    while (idxLast >= 0 && positiveArr1 >= 0 && lastArr2 >= 0) {
      if(arr1[positiveArr1] > arr2[lastArr2]) {
        arr1[idxLast] = arr1[positiveArr1];
        positiveArr1--;
      } else {
        arr1[idxLast] = arr2[lastArr2];
        lastArr2--;
      }
      idxLast--;
    }
    return arr1;
  }


}
