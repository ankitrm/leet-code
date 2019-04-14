package more;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSet {
  public static void main(String[] args) {

    int[] nums= {1, 2, 1};
    List<List<Integer>> subsets = subsets(nums);

    for (List<Integer> subset: subsets) {
      System.out.println(subset);
    }
  }

  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    subsetsHelper(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private static void subsetsHelper(List<List<Integer>> result , List<Integer> subResult, int [] nums, int start){
    result.add(new ArrayList<>(subResult));
    for(int i = start; i < nums.length; i++){
      // add element
      subResult.add(nums[i]);
      // Explore
      subsetsHelper(result, subResult, nums, i + 1);
      // remove
      subResult.remove(subResult.size() - 1);
    }
  }
}
