package facebook;

public class firstRepeatedOccurrence {
  public static void main(String[] args) {
    System.out.println(firstRepeatedOccurrence(new int[] {1, 2, 3, 3, 7, 8, 8, 9, 10, 11}, 3));
  }

  private static int firstRepeatedOccurrence(int[] arr, int target) {
    int low = 0, high = arr.length-1;
    int prevIdx = -1;
    while(low <= high) {
      int mid = (low + high + 1) / 2;
      if(arr[mid] == target) {
        prevIdx = mid;
        high = mid - 1;
      }
      if(arr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return prevIdx;
  }
}
