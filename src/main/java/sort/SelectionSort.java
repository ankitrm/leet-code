package sort;

public class SelectionSort {
  public static void main(String[] args) {

    int[] arr = {64, 25, 12, 22, 11};
    for(int i = 0;i < arr.length; i ++) {
      int max = i;
      for(int j = i+1; j < arr.length; j ++) {
        if(arr[max] > arr[j]) {
          max = j;
        }
      }
      int temp2 = arr[i];
      arr[i] = arr[max];
      arr[max] = temp2;
    }
    for(int ele: arr) {
      System.out.print(ele+" ");
    }
  }
}
