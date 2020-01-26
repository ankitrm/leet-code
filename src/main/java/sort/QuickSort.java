package sort;

public class QuickSort {
  public static void main(String[] args) {
    int arr[] = {10, 80, 30, 90, 40, 50, 70, 5};
    quickSort(0, arr.length-1, arr);
    System.out.println("hello");
  }

  private static void quickSort(int low, int high, int[] arr) {
    if (low < high) {
      int wall = divide(low, high, arr);
      quickSort(low, wall - 1, arr);
      quickSort(wall + 1, high, arr);
    }
  }

  private static int divide(int low, int high, int[] arr) {
    int pivot = arr[high];
    int i = low;
    for(int j = low; j < high; j ++) {
      if(arr[j] <= pivot) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
    return i;
  }
}
