// Ref: https://leetcode.com/problems/longest-palindromic-substring/

public class Ex5_Longest_palindrome {
  public static void main(String[] args) {
    System.out.println("Longest palindrome substring : "+ longestPalindromeSubString("abbba"));
  }

  private static String longestPalindromeSubString(String str) {
    if(str.isEmpty()) {
      return str;
    }
    int low = 0;
    int high = 0;

    for(int i = 0 ; i < str.length(); i ++) {
      int lengthOdd = lengthFromCenter(i, i, str);
      int lengthEven = lengthFromCenter(i, i+1, str);
      int length = Math.max(lengthOdd, lengthEven);
      if(length > high - low) {
        low = i - (length-1)/2;
        high = i + length / 2;
      }
    }
       return str.substring(low, high + 1);
  }

  private static int lengthFromCenter(int i, int j, String str) {
    while(i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
      i--;
      j++;
    }
    return j - i - 1;
  }
}
