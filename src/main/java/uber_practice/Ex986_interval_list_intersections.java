package uber_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/interval-list-intersections/submissions/
 */
public class Ex986_interval_list_intersections {
    public static void main(String[] args) {
        int[][] res = intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static class Interval {
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int start, end;
    }

    private static int[][] intervalIntersection(int[][] ints, int[][] ints1) {
        List<Interval> lst1 = Arrays.stream(ints).map(aa -> new Interval(aa[0], aa[1])).collect(Collectors.toList());
        List<Interval> lst2 = Arrays.stream(ints1).map(aa -> new Interval(aa[0], aa[1])).collect(Collectors.toList());

        List<Interval> result = new ArrayList<>();
        int idxa = 0, idxb = 0;

        while (idxa < lst1.size() && idxb < lst2.size()) {
            int min = Math.max(lst1.get(idxa).start, lst2.get(idxb).start);
            int max = Math.min(lst1.get(idxa).end, lst2.get(idxb).end);

            if (min <= max) {
                result.add(new Interval(min, max));
            }
            if (lst1.get(idxa).end < lst2.get(idxb).end) {
                idxa++;
            } else {
                idxb++;
            }
        }
        int[][] res = new int[result.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i][0] = result.get(i).start;
            res[i][1] = result.get(i).end;
        }

        return res;
    }
}
