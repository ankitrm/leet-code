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
        int max_x = a.length;
        int max_y = a[0].length;
        int dp[][] = new int[max_x][max_y];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                if (dp[i][j] == -1) {
                    // find longest from i,j
                    findLongestFromCell(a, dp, i, j);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    private static int findLongestFromCell(int[][] a, int[][] dp, int i, int j) {
        int max_x = a.length;
        int max_y = a[0].length;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(i+1 < max_x && (a[i][j] + 1 == a[i+1][j])) {
            dp[i][j] = 1 + findLongestFromCell(a, dp , i+1, j);
            return dp[i][j];
        }

        if(i-1 >= 0 && (a[i][j] + 1 == a[i-1][j])) {
            dp[i][j] = 1 + findLongestFromCell(a, dp , i-1, j);
            return dp[i][j];
        }

        if(j+1 < max_y && (a[i][j] + 1 == a[i][j+1])) {
            dp[i][j] = 1 + findLongestFromCell(a, dp , i, j+1);
            return dp[i][j];
        }

        if(j-1 >=0 && (a[i][j] + 1 == a[i][j-1])) {
            dp[i][j] = 1 + findLongestFromCell(a, dp , i, j-1);
            return dp[i][j];
        }
        dp[i][j] = 1;
        return 1;
    }
}
