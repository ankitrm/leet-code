package trees;

/**
 * // TODO Comment
 */
public class TNode {
    public int getVal() {
        return val;
    }

    public TNode getLeft() {
        return left;
    }

    public TNode getRight() {
        return right;
    }

    int val;
    TNode left = null, right = null;
    TNode(int val) {
        this.val = val;
    }
}
