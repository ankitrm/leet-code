package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * // https://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSort {
  public static void main(String[] args) {
    Graph g = new Graph();
    g.addEdge(4, 0);
    g.addEdge(5, 0);
    g.addEdge(2, 3);
    g.addEdge(5, 2);
    g.addEdge(3, 6);
    g.addEdge(4, 1);
    g.addEdge(3, 1);

    System.out.println("Following is a Topological " +
        "sort of the given graph");
    System.out.println(g.topologicalSort());
  }

  static class Graph {
    private Map<Integer, Set<Integer>> edges = new HashMap<>();

    public void addEdge(int from, int to) {
      if (edges.containsKey(from)) {
        Set<Integer> tos = edges.get(from);
        tos.add(to);
        edges.put(from, tos);
      } else {
        edges.put(from, new HashSet<Integer>() {{
          add(to);
        }});
      }
    }

    public List<Integer> topologicalSort() {
      Stack<Integer> result = new Stack<>();
      Set<Integer> keys = edges.keySet();

      Set<Integer> visited = new HashSet<>();
      for (Integer key : keys) {
        if (!visited.contains(key)) {
          topologicalSort(result, key, edges, visited);
        }
      }

      List<Integer> lst = new ArrayList<>();
      while (!result.isEmpty()) {
        lst.add(result.pop());
      }
      return lst;
    }

    private void topologicalSort(Stack<Integer> result, Integer key, Map<Integer, Set<Integer>> edges, Set<Integer> visited) {
      visited.add(key);
      if (edges.containsKey(key)) {
        for (Integer val : edges.get(key)) {
          if (!visited.contains(val)) {
            topologicalSort(result, val, edges, visited);
          }
        }
      }
      result.push(key);
    }
  }

}