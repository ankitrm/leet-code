/**
 * Ref: https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class Ex_516_Longest_Palindromic_Subsequence {
  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("geke"));
  }

  private static int longestPalindromeSubseq(String str) {
    int[][] dp = new int[str.length()][str.length()];
    return longestPalindrome(str.toCharArray(), 0, str.length() - 1, dp);
  }

  private static int longestPalindrome(char[] ch, int i, int j, int[][] dp) {
    if (i > j) {
      return 0;
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    }

    if (i == j) {
      dp[i][j] = 1;
    } else if (ch[i] == ch[j]) {
      dp[i][j] = 2 + longestPalindrome(ch, i + 1, j - 1, dp);
    } else {
      dp[i][j] = Math.max(longestPalindrome(ch, i + 1, j, dp), longestPalindrome(ch, i, j - 1, dp));
    }
    return dp[i][j];
  }


}