public class Ex3_Longest_Substring {

  // Ref: https://leetcode.com/problems/longest-substring-without-repeating-characters

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("ababcbcd"));
  }

  private static int lengthOfLongestSubstring(String str) {
    if (str.isEmpty()) {
      return 0;
    }
    int start = 0;
    int end = 1;

    int tempStart = 0;
    int tempEnd = 1;

    for (int i = 1; i < str.length() && tempEnd <= str.length(); i++) {

      char newChar = str.charAt(i);
      boolean isUnique = true;
      for (int j = tempStart; j < tempEnd; j++) {
        if (str.charAt(j) == newChar) {
          isUnique = false;
          tempStart = j + 1;
          break;
        }
      }
      tempEnd++;
      if (isUnique) {
        if (tempEnd - tempStart > end - start) {
          start = tempStart;
          end = tempEnd;
        }
      }
    }
    return (end - start);
  }
}
