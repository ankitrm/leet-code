package subsets;

import java.util.ArrayList;
import java.util.List;

public class Ex131_Palindrome_Partitioning {

  public static void main(String[] args) {
    partition("aabbb").forEach(System.out::println);
  }

  static List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    partition(s, res, new ArrayList<>(), 0);
    return res;
  }

  private static void partition(String s, List<List<String>> res, ArrayList<String> temp, int idx) {
    if (idx == s.length()) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = idx; i < s.length(); i++) {
        if (isPalindrome(s, idx, i)) {
          temp.add(s.substring(idx, i + 1));
          partition(s, res, temp, i + 1);
          temp.remove(temp.size() - 1);
        }
      }
    }
  }

  private static boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }
}
