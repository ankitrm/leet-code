package trees;

import java.util.*;

class Bfs {
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
}
