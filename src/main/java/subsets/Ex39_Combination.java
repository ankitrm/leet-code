package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ref: https://leetcode.com/problems/combination-sum/
public class Ex39_Combination {
  public static void main(String[] args) {
    subsets(new int[] {2, 3, 6, 7}, 7).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    subsets(nums, res, new ArrayList<>(), sum, 0);
    return res;
  }

  private static void subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int target, int idx) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = idx; i < nums.length; i++) {
        temp.add(nums[i]);
        subsets(nums, res, temp, target - nums[i], i);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
