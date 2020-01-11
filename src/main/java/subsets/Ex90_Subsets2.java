package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ref: https://leetcode.com/problems/subsets-ii/
public class Ex90_Subsets2 {
  public static void main(String[] args) {
    subsets(new int[] {4,4,4,1,4}).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    return subsets(nums, res, new ArrayList<>(), 0);
  }

  private static List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int idx) {
    if (!res.contains(temp)) {
      res.add(new ArrayList<>(temp));
    }
    for (int i = idx; i < nums.length; i++) {
        temp.add(nums[i]);
        subsets(nums, res, temp, i + 1);
        temp.remove(temp.size() - 1);
    }
    return res;
  }
}
