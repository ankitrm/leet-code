import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class Ex1_two_sum {
  public static void main(String[] args) {
    int[] arr = new int[] {2, 7, 11, 15};
    int[] newArr = twoSum(arr, 9);
    if (null != newArr) {
      for (int aNewArr : newArr) {
        System.out.print(aNewArr);
      }
    }
  }

  private static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int difference = target - nums[i];
      if (hashMap.containsKey(difference)) {
        return new int[] {hashMap.get(difference), i};
      } else {
        hashMap.put(nums[i], i);
      }
    }
    return null;
  }
}
