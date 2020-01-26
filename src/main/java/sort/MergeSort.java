package sort;

public class MergeSort {
  public static void main(String[] args) {
    int arr[] = {10, 80, 30, 90, 40, 50, 70, 5};
    sort(0, arr.length - 1, arr);
    System.out.println("hello");
  }

  private static void sort(int low, int high, int[] arr) {
    if (low < high) {
      int mid = (low + high) / 2;
      sort(low, mid, arr);
      sort(mid + 1, high, arr);
      merge(arr, low, high, mid);
    }
  }

  private static void merge(int[] arr, int low, int high, int mid) {
    int leftSize = mid - low + 1;
    int rightSize = high - mid;
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];

    for (int i = 0; i < leftSize; i++) {
      left[i] = arr[low + i];
    }

    for (int i = 0; i < rightSize; i++) {
      right[i] = arr[mid + 1 + i];
    }
    int i = 0, j = 0, k = low;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        k++;
        i++;
      } else {
        arr[k] = right[j];
        k++;
        j++;
      }
    }
    while (i < left.length) {
      arr[k] = left[i];
      k++;
      i++;
    }
    while (j < right.length) {
      arr[k] = right[j];
      k++;
      j++;
    }
  }
}
