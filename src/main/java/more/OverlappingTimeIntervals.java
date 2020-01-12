package more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OverlappingTimeIntervals {
  public static void main(String[] args) {
    List mergedtimeIntervals = mergeOverlappingSlots(new int[][] {
        {4, 7},
        {5, 5},
        {1, 2},
        {9, 11},
        {6, 8},
        {3, 4}
    });
    // Output should be {{1, 2}, {3, 8}, {9, 11}}
    mergedtimeIntervals.forEach(System.out::println);
  }

  private static List mergeOverlappingSlots(int[][] ele) {
    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> elements = new ArrayList<>();
    for (int[] ints : ele) {
      List<Integer> lst = Arrays.stream(ints).boxed().collect(Collectors.toList());
      elements.add(new ArrayList<>(lst));
    }
    elements.sort(Comparator.comparing(o -> o.get(0)));

    int start1 = elements.get(0).get(0);
    int end1 = elements.get(0).get(1);

    for (int i = 1; i < elements.size(); i++) {
      int start2 = elements.get(i).get(0);
      int end2 = elements.get(i).get(1);

      if (start1 <= start2 && end1 >= start2 && end1 <= end2) {
        end1 = end2;
      } else if (end1 >= start2 && end1 >= end2) {
        // Skip the record
      } else {
        result.add(new ArrayList<>(Arrays.asList(start1, end1)));
        start1 = start2;
        end1 = end2;
      }
    }
    result.add(new ArrayList<>(Arrays.asList(start1, end1)));
    return result;
  }
}
