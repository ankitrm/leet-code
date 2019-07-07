package facebook;

/**
 * https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 */
public class LongestSequenceArray {
    public static void main(String[] args) {
        int a[][] = {{9, 2, 1},
                {7, 3, 6},
                {8, 4, 5}};

        System.out.println(longestSequence(a));
    }

    private static int longestSequence(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        markAll(dp, -1);

        int max = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                max = Math.max(max, markEachNodeLongestSequence(a, dp, i, j));
            }
        }
        return max;

    }

    private static int markEachNodeLongestSequence(int[][] a, int[][] dp, int row, int col) {
        int max_x = a.length - 1;
        int max_y = a[0].length - 1;

        int valueUnderConsid = a[row][col];

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (row + 1 <= max_x && (valueUnderConsid + 1 == a[row + 1][col])) {
            return dp[row][col] = 1 + markEachNodeLongestSequence(a, dp, row + 1, col);
        }

        if (row - 1 >= 0 && (valueUnderConsid + 1 == a[row - 1][col])) {
            return dp[row][col] = 1 + markEachNodeLongestSequence(a, dp, row - 1, col);
        }

        if (col + 1 <= max_y && (valueUnderConsid + 1 == a[row][col + 1])) {
            return dp[row][col] = 1 + markEachNodeLongestSequence(a, dp, row, col + 1);
        }

        if (col - 1 >= 0 && (valueUnderConsid + 1 == a[row][col - 1])) {
            return dp[row][col] = 1 + markEachNodeLongestSequence(a, dp, row, col - 1);
        }

        return dp[row][col] = 1;
    }

    private static void markAll(int[][] dp, int newValue) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = newValue;
            }
        }
    }


}
