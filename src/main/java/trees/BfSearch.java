package trees;

import java.util.*;

class BfSearch {
    List<Integer> traverseBFS(TNode rootNode) {
        List<Integer> result = new ArrayList<>();
        if(rootNode == null) {
            return result;
        }


        Queue<TNode> tempQueue = new LinkedList<>();
        tempQueue.add(rootNode);
        while(!tempQueue.isEmpty()) {
            TNode tempNode = tempQueue.poll();
            result.add(tempNode.val);
            if(tempNode.left != null) {
                tempQueue.add(tempNode.left);
            }
            if(tempNode.right != null) {
                tempQueue.add(tempNode.right);
            }
        }
        return result;
    }

    List<Integer> zigZagTree(TNode rootNode) {
        List<Integer> result = new ArrayList<>();

        boolean isRightToLeft = true;
        Stack<TNode> stack = new Stack<>();
        Stack<TNode> tempStack = new Stack<>();
        stack.add(rootNode);

        while(!stack.isEmpty()) {
            TNode tempNode = stack.pop();
            result.add(tempNode.val);
            if(isRightToLeft) {
                if(tempNode.left!=null) {
                    tempStack.add(tempNode.left);
                }
                if(tempNode.right!=null) {
                    tempStack.add(tempNode.right);
                }
            } else {
                if(tempNode.right!=null) {
                    tempStack.add(tempNode.right);
                }
                if(tempNode.left!=null) {
                    tempStack.add(tempNode.left);
                }
            }
            if(stack.isEmpty()) {
                stack = tempStack;
                tempStack = new Stack<>();
                isRightToLeft = !isRightToLeft;
            }
        }
        return result;
    }
    public List<Integer> averagePerLevel(TNode rootNode) {
        List<Integer> result = new LinkedList<>();
        if (rootNode == null) {
            return result;
        }
        Queue<TNodeWithLevels> tempQueue = new LinkedList<>();
        tempQueue.add(new TNodeWithLevels(rootNode, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<Integer>() {{
            add(rootNode.val);
        }});
        while (!tempQueue.isEmpty()) {
            TNodeWithLevels nodeWithLevel = tempQueue.poll();
            if (nodeWithLevel.node.left != null) {
                putElementInMap(map, nodeWithLevel.node.left, nodeWithLevel.level + 1);
                tempQueue.add(new TNodeWithLevels(nodeWithLevel.node.left, nodeWithLevel.level + 1));
            }
            if (nodeWithLevel.node.right != null) {
                putElementInMap(map, nodeWithLevel.node.right, nodeWithLevel.level + 1);
                tempQueue.add(new TNodeWithLevels(nodeWithLevel.node.right, nodeWithLevel.level + 1));
            }
        }
        for (List<Integer> list : map.values()) {
            int sum = 0;
            for (int ele : list) {
                sum += ele;
            }
            result.add(sum / list.size());
        }
        return result;
    }

    private void putElementInMap(Map<Integer, List<Integer>> map, TNode node, int level) {
        if (map.containsKey(level)) {
            List<Integer> tempList = map.get(level);
            tempList.add(node.val);
            map.put(level, tempList);
        } else {
            map.put(level, new ArrayList<Integer>() {{
                add(node.val);
            }});
        }
    }

    private static class TNodeWithLevels {
        TNode node;
        int level;

        public TNodeWithLevels(TNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
