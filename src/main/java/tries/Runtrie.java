package tries;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * // TODO Comment
 */
public class Runtrie {
    public static void main(String[] args) {
        TrieDictionary trieDictionary = new TrieDictionary();
        String dictionary = "quick brown fox jumped over a lazy dog";
        String input = "a shit hello dog not browned";

        // ans should be "a dog browned"
        for(String str: dictionary.split("\\s")) {
            trieDictionary.add(str);
        }

        String result = "";
        //for(String inp: input.split("\\s")) {
        List<String> str = Arrays.stream(input.split("\\s")).filter(trieDictionary::contains).collect(Collectors.toList());
        for(String s: str) {
            System.out.println(s);
        }

    }
}
