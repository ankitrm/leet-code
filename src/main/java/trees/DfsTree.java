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
    if (root != null) {
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
    if (root != null) {
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
    if (root != null) {
      traversePostorder(root.left);
      System.out.print(root.val + " ");
      traversePostorder(root.right);
    }
  }

  boolean exists(TNode node, int ele) {
    if (node == null) {
      return false;
    }
    if (node.val == ele) {
      return true;
    }
    if (ele < node.val) {
      return exists(node.left, ele);
    } else {
      return exists(node.right, ele);
    }
  }

  /*public int diameter(TNode rootNode) {
    if (rootNode == null) {
      return 0;
    }

    int currentDiameter = height(rootNode.left) + height(rootNode.right);

    int diamL = diameter(rootNode.left);
    int diamR = diameter(rootNode.right);

    return Math.max(Math.max(diamL, diamR), currentDiameter);
  }*/

/*  int max = 0;
  public int diameter(TNode rootNode) {
    diameter2(rootNode);
    return max;
  }
  public int diameter2(TNode rootNode) {
    if (rootNode == null) {
      return 0;
    }

    int diamL = diameter2(rootNode.left).;
    int diamR = diameter2(rootNode.right);

    // computes the max
    max = Math.max(max, diamL + diamR);

    // Continues to compute the height
    return 1 + Math.max(diamL, diamR);
  }*/

  class Height {
    int h;
  }
  public int diameter(TNode rootNode) {
    Height height = new Height();
    diameter2(rootNode, height);
    return height.h;
  }
  public int diameter2(TNode rootNode, Height height) {
    if (rootNode == null) {
      return 0;
    }

    int diamL = diameter2(rootNode.left, new Height());
    int diamR = diameter2(rootNode.right, new Height());

    // computes the max
    height.h = Math.max(height.h, diamL + diamR);

    // Continues to compute the height
    return 1 + Math.max(diamL, diamR);
  }


  public int height(TNode rootNode) {
    if (rootNode == null) {
      return 0;
    }
    return 1 + Math.max(height(rootNode.left), height(rootNode.right));
  }
}