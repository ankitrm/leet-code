package sort;

/**
 *
 */
public class InsertionSort {
  public static void main(String[] args) {
    int[] elements = {5, 8, 1, 3, 9, 6};

    for (int i = 1; i < elements.length; i++) {
      int j = i - 1;
      int key = elements[i];
      while (j >= 0 && elements[j] > key) {
        elements[j + 1] = elements[j];
        j--;
      }
      elements[j+1] = key;
    }
    for (int ele : elements) {
      System.out.print(ele);
    }
  }
}
