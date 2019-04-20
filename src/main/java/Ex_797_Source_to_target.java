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
    int start = 0;
    List<Integer> midResult = new ArrayList<>();
    midResult.add(0);
    List<List<Integer>> result = new ArrayList<>();
    bfsTraversal(start, input, midResult, result);
    return result;  // TODO impl
  }

  private static void bfsTraversal(int path, int[][] input, List<Integer> midResult, List<List<Integer>> result) {
    if (path == input.length - 1) {
      result.add(new ArrayList<>(midResult));
    } else {
      for (int nextEle : input[path]) {
        midResult.add(nextEle);
        bfsTraversal(nextEle, input, midResult, result);
        midResult.remove(midResult.size() - 1);
      }
    }
  }
}
