import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class Ex_49_group_anagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(!hMap.containsKey(sortedStr)) {
                hMap.put(sortedStr, new ArrayList<>());
            }
            hMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(hMap.values());
    }
}
