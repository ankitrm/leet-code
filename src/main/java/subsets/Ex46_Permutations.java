package subsets;

import java.util.ArrayList;
import java.util.List;

// Ref: https://leetcode.com/problems/permutations/
public class Ex46_Permutations {
  public static void main(String[] args) {
    subsets(new int[]{1,2,3}).forEach(System.out::println);
  }

  static List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> res = new ArrayList<>();
     return subsets(nums, res, new ArrayList<>());
  }

  private static List<List<Integer>> subsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp) {
    if(temp.size() == nums.length)
      res.add(new ArrayList<>(temp));

    for(int i = 0; i < nums.length; i++) {
      if(!temp.contains(nums[i])) {
        temp.add(nums[i]);
        subsets(nums, res, temp);
        temp.remove(temp.size() - 1);
      }
    }

    return res;
  }
}
