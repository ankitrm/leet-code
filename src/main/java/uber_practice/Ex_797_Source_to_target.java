package uber_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class Ex_797_Source_to_target {
  public static void main(String[] args) {
    int[][] input = {{1, 2}, {3}, {3}, {}};
    System.out.println(allPathsSourceTarget(input));
  }

  private static List<List<Integer>> allPathsSourceTarget(int[][] input) {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new ArrayList<Integer>(){{add(0);}};
    allSubsets(0, input, subResult, result);
    return result;
  }

  private static void allSubsets(int path, int[][] input, List<Integer> subresult, List<List<Integer>> result) {
    if(path == input.length - 1) {
      result.add(new ArrayList<>(subresult));
    }
    for(int ele: input[path]) {
      subresult.add(ele);
      allSubsets(ele, input, subresult, result);
      subresult.remove(subresult.size() - 1);
    }
  }
}
