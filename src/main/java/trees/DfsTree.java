package trees;

/**
 * // TODO Comment
 */
class DfsTree {
  void postOrderRecur(TNode rootNode) {
    traversePostorder(rootNode);
    System.out.println();
  }

  private void traversePostorder(TNode root) {
    if(root != null) {
      traversePostorder(root.left);
      traversePostorder(root.right);
      System.out.print(root.val + " ");
    }
  }

  void preOrderRecur(TNode root) {
    traversePreorder(root);
    System.out.println();
  }

  private void traversePreorder(TNode root) {
    if(root != null) {
      System.out.print(root.val + " ");
      traversePostorder(root.left);
      traversePostorder(root.right);
    }
  }

  void inOrderRecur(TNode root) {
    traverseInorder(root);
    System.out.println();
  }

  private void traverseInorder(TNode root) {
    if(root != null) {
      traversePostorder(root.left);
      System.out.print(root.val + " ");
      traversePostorder(root.right);
    }
  }

  boolean exists(TNode node, int ele) {
    if(node == null) {
      return false;
    }
    if(node.val == ele) {
      return true;
    }
    if(ele < node.val) {
      return exists(node.left, ele);
    } else {
      return exists(node.right, ele);
    }
  }

  public int height(TNode rootNode) {
    return count(rootNode, 0);
  }

  private int count(TNode rootNode, int i) {
    if(rootNode != null) {
      return Math.max(count(rootNode.left, i+1), count(rootNode.right, i+1));
    }
    return i;
  }
}