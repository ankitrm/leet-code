package trees;

import java.util.*;

/**
 * // TODO Comment
 */
class VerticalOrder {

    void verticalOrder(TNode rootNode) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        getVerticalOrder(rootNode, 0, map);

        for(List sd: map.values()) {
            System.out.println(sd);
        }
        System.out.println();
    }

    private void getVerticalOrder(TNode node, int i, Map<Integer, List<Integer>> map) {
        if(node != null) {
            if (map.containsKey(i)) {
                List<Integer> values = map.get(i);
                values.add(node.val);
                map.replace(i, values);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(node.val);
                map.put(i, values);
            }
            getVerticalOrder(node.left, i-1, map);
            getVerticalOrder(node.right, i+1, map);
        }
    }
}
