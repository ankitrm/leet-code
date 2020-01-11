package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ref: https://leetcode.com/problems/combination-sum-ii/
public class Ex40_Combinations2 {
  public static void main(String[] args) {
    subsets(new int[] {10, 1, 2, 7, 6, 1, 5}, 8).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    subsets(nums, res, new ArrayList<>(), target, 0);
    return res;
  }

  private static void subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int target, int idx) {
    if (target < 0) {
      return;
    } else if (target == 0 && !res.contains(temp)) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = idx; i < nums.length; i++) {
        temp.add(nums[i]);
        subsets(nums, res, temp, target - nums[i], i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
