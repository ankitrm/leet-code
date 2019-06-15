import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Ex103_btree_zig_zag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        boolean isRightToLeft = true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        stack.add(root);

        List<Integer> tempresult = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            tempresult.add(tempNode.getVal());
            if(isRightToLeft) {
                if(tempNode.getLeft()!=null) {
                    tempStack.add(tempNode.getLeft());
                }
                if(tempNode.getRight()!=null) {
                    tempStack.add(tempNode.getRight());
                }
            } else {
                if(tempNode.getRight()!=null) {
                    tempStack.add(tempNode.getRight());
                }
                if(tempNode.getLeft()!=null) {
                    tempStack.add(tempNode.getLeft());
                }
            }
            if(stack.isEmpty()) {
                stack = tempStack;
                tempStack = new Stack<>();
                isRightToLeft = !isRightToLeft;
                result.add(tempresult);
                tempresult = new ArrayList<>();
            }
        }
        return result;
    }
}
