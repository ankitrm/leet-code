package aws.minimum_construction_cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class MinCostToConstruct2 {

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

  private static class Road {
    private int city1;
    private int city2;

    Road(int city1, int city2) {
      this.city1 = city1;
      this.city2 = city2;
    }

    int getCity1() {
      return city1;
    }

    int getCity2() {
      return city2;
    }

    public boolean containsCity(int city) {
      return city1 == city || city2 == city;
    }
  }

  private static class RoadWithCost {
    private Road cityPair;
    private int cost;

    RoadWithCost(Road cityPair, int cost) {
      this.cityPair = cityPair;
      this.cost = cost;
    }

    Road getCityPair() {
      return cityPair;
    }

    int getCost() {
      return cost;
    }
  }

  public static class ListOfRoadsWithWeight {
    private List<RoadWithCost> roads;

    ListOfRoadsWithWeight(List<RoadWithCost> roads) {
      this.roads = roads;
    }


    List<RoadWithCost> getRoads() {
      return roads;
    }

    public void add(RoadWithCost roadWithCost) {
      this.roads.add(roadWithCost);
    }

    public void remove(int index) {
      this.roads.remove(index);
    }

    int getWeight() {
      int sum = 0;
      for(int i = 0; i < getRoads().size(); i++) {
        sum += getRoads().get(i).getCost();
      }
      return sum;
    }
  }

  static int getMinimumCostToConstruct(int numTotalAvailableCitites, int numTotalAvailableRoads, List<List<Integer>> roadsAvailable, int numNewRoadsConstruct, List<List<Integer>> costNewRoadsConstruct) {
    List<Road> roads = roadsAvailable.stream().map(road -> new Road(road.get(0), road.get(1))).collect(Collectors.toList());
    List<RoadWithCost> roadWithCosts = costNewRoadsConstruct.stream().map(roadWithCost -> new RoadWithCost(new Road(roadWithCost.get(0), roadWithCost.get(1)), roadWithCost.get(2))).collect(Collectors.toList());
    return getMinimumCostToConstruct2(numTotalAvailableCitites, numTotalAvailableRoads, roads, numNewRoadsConstruct, roadWithCosts);
  }

  static int getMinimumCostToConstruct2(int numTotalAvailableCitites, int numTotalAvailableRoads, List<Road> roads, int maximumRoadsAllowedToAdd, List<RoadWithCost> roadsWithCost) {
    final HashMap<Integer, Set<Integer>> pathsFromEveryNode = getPathsFromEveryNode(roads, new HashMap<>());
    if (areAllCitiesReachable(pathsFromEveryNode, numTotalAvailableCitites)) {
      return 0;
    }
    int minCost = Integer.MAX_VALUE;
    List<ListOfRoadsWithWeight> roadsWithCoveredCosts = getAllAvailableRoadsWithTotalCostCovered(maximumRoadsAllowedToAdd, roadsWithCost);
    for (ListOfRoadsWithWeight roadsWithCoveredCost : roadsWithCoveredCosts) {
      if(roadsWithCoveredCost.getRoads().isEmpty()) {
        continue;
      }
      HashMap<Integer, Set<Integer>> newPaths = getPathsFromEveryNode(roadsWithCoveredCost.getRoads().stream().map(RoadWithCost::getCityPair).collect(Collectors.toList()), pathsFromEveryNode);
      if (areAllCitiesReachable(newPaths, numTotalAvailableCitites)) {
        int weight = roadsWithCoveredCost.getWeight();
        minCost = Math.min(minCost, weight);
      }
    }
    return minCost == Integer.MAX_VALUE ? -1 : minCost;
  }

  private static HashMap<Integer, Set<Integer>> getPathsFromEveryNode(List<Road> roads, HashMap<Integer, Set<Integer>> pathsFromEveryNode) {
    HashMap<Integer, Set<Integer>> pathsToEveryNode = new HashMap<>();
    for(int key: pathsFromEveryNode.keySet()) {
      pathsToEveryNode.put(key, new HashSet<Integer>() {{
        addAll(pathsFromEveryNode.get(key));
      }});
    }

    for (Road road : roads) {
      boolean isFound = false;
      if (pathsToEveryNode.containsKey(road.getCity1())) {
        Set<Integer> newDestinations = pathsToEveryNode.get(road.getCity1());
        newDestinations.add(road.getCity2());
        pathsToEveryNode.put(road.getCity1(), newDestinations);
        isFound = true;
      }
      if (pathsToEveryNode.containsKey(road.getCity2())) {
        Set<Integer> newDestinations = pathsToEveryNode.get(road.getCity2());
        newDestinations.add(road.getCity1());
        pathsToEveryNode.put(road.getCity2(), newDestinations);
        isFound = true;
      }
      if (!isFound) {
        pathsToEveryNode.put(road.getCity1(), new HashSet<Integer>() {{
          add(road.getCity2());
        }});
        pathsToEveryNode.put(road.getCity2(), new HashSet<Integer>() {{
          add(road.getCity1());
        }});
      }
    }
    return pathsToEveryNode;
  }

  private static boolean areAllCitiesReachable(HashMap<Integer, Set<Integer>> pathsFromEveryNode, int numTotalAvailableCities) {
    boolean[] isVisited = new boolean[numTotalAvailableCities];
    for (int i = 0; i < isVisited.length; i++) {
      isVisited[i] = false;
    }
    int anyCity = new ArrayList<>(pathsFromEveryNode.keySet()).get(0);

    Queue<Integer> queue = new LinkedList<Integer>() {{
      add(anyCity);
    }};
    while (!queue.isEmpty()) {
      int ele = queue.poll();
      if (!isVisited[ele - 1]) {
        isVisited[ele - 1] = true;
      }
      if (pathsFromEveryNode.containsKey(ele)) {
        queue.addAll(pathsFromEveryNode.get(ele).stream().filter(city -> !isVisited[city - 1]).collect(Collectors.toList()));
      }
    }
    for (boolean b : isVisited) {
      if (!b) {
        return false;
      }
    }
    return true;
  }

  private static List<ListOfRoadsWithWeight> getAllAvailableRoadsWithTotalCostCovered(int maximumRoadsAllowedToAdd, List<RoadWithCost> roadsWithCost) {
    List<ListOfRoadsWithWeight> result = new ArrayList<>();

    ListOfRoadsWithWeight roadsWithCoveredCost = new ListOfRoadsWithWeight(new ArrayList<>());
    return subsetsWithLimit(result, roadsWithCoveredCost, roadsWithCost, 0, maximumRoadsAllowedToAdd);
  }

  private static List<ListOfRoadsWithWeight> subsetsWithLimit(List<ListOfRoadsWithWeight> result, ListOfRoadsWithWeight roadsWithCoveredCost, List<RoadWithCost> roadsWithCost, int start, int maximumRoadsAllowedToAdd) {
    if (roadsWithCoveredCost.getRoads().size() <= maximumRoadsAllowedToAdd) {
      result.add(new ListOfRoadsWithWeight(new ArrayList<>(roadsWithCoveredCost.getRoads())));
    }
    for (int i = start; i < roadsWithCost.size(); i++) {
      // add element
      roadsWithCoveredCost.add(roadsWithCost.get(i));
      // Explore
      subsetsWithLimit(result, roadsWithCoveredCost, roadsWithCost, i + 1, maximumRoadsAllowedToAdd);
      // remove
      roadsWithCoveredCost.remove(roadsWithCoveredCost.getRoads().size() - 1);
    }
    return result;
  }
}
