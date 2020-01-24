package aws;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingChar {
  public static void main(String[] args) {
    System.out.println(firstNonRepeatingChar("GeeeksForGeeks"));
  }

  private static int firstNonRepeatingChar(String input) {
    Map<Character, Integer> map = new HashMap<>();
    Set<Character> set = new LinkedHashSet<>();
    for(int i = 0; i < input.length(); i++) {
      Character ch = input.charAt(i);
      if(map.containsKey(ch)) {
        set.remove(ch);
      } else {
        map.put(ch, i);
        set.add(ch);
      }
    }
    return set.isEmpty()? -1 : map.get(set.iterator().next());
  }
}
