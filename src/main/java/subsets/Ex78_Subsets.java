package subsets;

import java.util.ArrayList;
import java.util.List;

// Ref: https://leetcode.com/problems/subsets/
public class Ex78_Subsets {
  public static void main(String[] args) {
    subsets(new int[]{1,2,3}).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> res = new ArrayList<>();
     return subsets(nums, res, new ArrayList<>(), 0);
  }

  private static List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int idx) {
    res.add(new ArrayList<>(temp));

    for(int i = idx; i < nums.length; i++) {
      temp.add(nums[i]);
      subsets(nums, res, temp, i+1);
      temp.remove(temp.size() - 1);
    }

    return res;
  }
}
