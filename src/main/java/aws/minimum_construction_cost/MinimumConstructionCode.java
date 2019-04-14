package aws.minimum_construction_cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class MinimumConstructionCode {
  public static void main(String[] args) {
    List<List<Integer>> roadsAvailable = new ArrayList<>(Arrays.asList(Arrays.asList(1, 4), Arrays.asList(4, 5), Arrays.asList(2, 3)));
    List<List<Integer>> costNewRoadsConstruct = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 5), Arrays.asList(1, 3, 10), Arrays.asList(1, 6, 2), Arrays.asList(5, 6, 5)));

    System.out.println(getMinimumCostToConstruct(
        6,
        3,
        roadsAvailable,
        4,
        costNewRoadsConstruct
    ));
  }

  static int getMinimumCostToConstruct(int numTotalAvailableCitites, int numTotalAvailableRoads, List<List<Integer>> roadsAvailable, int numNewRoadsConstruct, List<List<Integer>> costNewRoadsConstruct) {
    boolean isAlreadyComplete = isComplete(roadsAvailable, numTotalAvailableCitites);
    if(isAlreadyComplete)
      return 0;

    int minCost = Integer.MAX_VALUE;

    List<List<List<Integer>>> allCombinationsOfRoadsToCost = new ArrayList<>();
    createCombinations(allCombinationsOfRoadsToCost, new ArrayList<>(), costNewRoadsConstruct, 0);


    for (List<List<Integer>> lists : allCombinationsOfRoadsToCost) {
      List<List<Integer>> listOfConnectingRoads = lists.stream().map(ll -> Arrays.asList(ll.get(0), ll.get(1))).collect(Collectors.toList());
      List<List<Integer>> allRoads = new ArrayList<>(roadsAvailable);
      allRoads.addAll(listOfConnectingRoads);
      if (isComplete(allRoads, numTotalAvailableCitites)) {
        Integer sum = lists.stream().mapToInt(a -> a.get(2)).sum();
        if (sum < minCost) {
          minCost = sum;
        }
      }
    }

    return minCost;
  }

  private static void createCombinations(List<List<List<Integer>>> result, List<List<Integer>> subResult, List<List<Integer>> input, int start) {
    if(subResult.size() != 0) {
      List<List<Integer>> temp = new ArrayList<>(subResult);
      result.add(new ArrayList<>(temp));
    }
    for (int i = start; i < input.size(); i++) {
      subResult.add(input.get(i));
      createCombinations(result, subResult, input, i+1);
      subResult.remove(subResult.size() - 1);
    }
  }

  private static boolean isComplete(List<List<Integer>> roadsAvailable, int numTotalAvailableCitites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (List<Integer> integers : roadsAvailable) {
      if (map.containsKey(integers.get(0))) {
        List<Integer> ele = map.get(integers.get(0));
        ele.add(integers.get(1));
        map.put(integers.get(0), ele);
      } else {
        List<Integer> lst = new ArrayList<>();
        lst.add(integers.get(1));
        map.put(integers.get(0), lst);
      }
    }

    Stack<Integer> stk = new Stack<>();
    stk.push(roadsAvailable.get(0).get(0));
    List<Integer> coveredCities = new ArrayList<>();
    while (!stk.empty()) {
      int ele = stk.pop();
      coveredCities.add(ele);
      if (map.containsKey(ele)) {
        stk.addAll(map.get(ele));
      }
    }
    return new HashSet<>(coveredCities).size() == numTotalAvailableCitites;
  }
}

