package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Ref: https://leetcode.com/problems/permutations-ii/
public class Ex47_Permutations2 {
  public static void main(String[] args) {
    subsets(new int[] {1, 2, 1}).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    return subsets(nums, res, new ArrayList<>(), new boolean[nums.length]);
  }

  private static List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, boolean[] used) {
    if(temp.size() == nums.length && !res.contains(temp))
      res.add(new ArrayList<>(temp));

    for (int i = 0; i < nums.length; i++) {
      if(!used[i]) {
        temp.add(nums[i]);
        used[i] = true;
        subsets(nums, res, temp, used);
        temp.remove(temp.size() - 1);
        used[i] = false;
      }
    }

    return res;
  }
}
