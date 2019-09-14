import java.util.Comparator;
import java.util.PriorityQueue;

public class Ex215_Kth_Largest {
  public static void main(String[] args) {
    // 1 2 2 3 3 4 5 4 6
    int[] arr = {3,2,3,1,2,4,5,5,6};
    int no = findKthLargest(arr, 10);
    System.out.print(no);
  }
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for(int i = 0; i< nums.length; i++ ) {
      queue.add(nums[i]);
      if(queue.size() > k) {
        queue.poll();
      }
    }
    return queue.peek();
  }
}
