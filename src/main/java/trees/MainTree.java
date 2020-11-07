package trees;

import java.util.List;
import java.util.stream.Collectors;

/**
 * // TODO Comment
 */
public class MainTree {
     public static void main(String[] args) {
        TNode rootNode = newInitTree();

        BfSearch bfSearch = new BfSearch();

        // 8 4 18 2 6 11 23 1 3 5 7 9 13 22 27
         printTree(bfSearch.traverseBFS(rootNode), "BFS Traversal");

         // Average: [8, 11, 10, 10]
         System.out.println("Operation:: Average per level ->");
         System.out.println(bfSearch.averagePerLevel(rootNode));
         System.out.println();

        // 8 18 4 2 6 11 23 27 22 13 9 7 5 3 1
         printTree(bfSearch.zigZagTree(rootNode), "ZigZag Traversal");


         DfsTree dfs = new DfsTree();
         // 1 3 2 5 7 6 4 9 13 11 22 27 23 18 8
          System.out.println("Operation:: Postorder ->");
          dfs.postOrderRecur(rootNode);

         // 8 4 2 1 3 6 5 7 18 11 9 13 23 22 27
          System.out.println("Operation:: Preorder ->");
          dfs.preOrderRecur(rootNode);

         // 1 2 3 4 5 6 7 8 9 11 13 18 22 23 27
          System.out.println("Operation:: Inorder ->");
          dfs.inOrderRecur(rootNode);


         // false
         System.out.println("Operation:: Exists 88 ->");
         System.out.println(dfs.exists(rootNode, 88));
         System.out.println();

         // true
         System.out.println("Operation:: Exists 22 ->");
         System.out.println(dfs.exists(rootNode, 22));
         System.out.println();


         /*
          * [1]
          * [2]
          * [4, 3, 5, 9]
          * [8, 6, 11]
          * [7, 18, 13, 22]
          * [23]
          * [27]
          */
          System.out.println("Operation:: Vertical order ->");
          VerticalOrder vOrder = new VerticalOrder();
          vOrder.verticalOrder(rootNode);


         // height: 4
         System.out.println("Operation:: Height ->");
         System.out.println(dfs.height(rootNode));
         System.out.println();

       // diameter: 6
       System.out.println("Operation:: Diameter ->");
       System.out.println(dfs.diameter(rootNode));
       System.out.println();

       // diameter: 6
       System.out.println("Operation:: Diameter ->");
       System.out.println(dfs.diameterHeight(rootNode));
       System.out.println();

    }

    private static void printTree(List<Integer> traverseBFS, String operation) {
        String result = traverseBFS.stream().map(Object::toString).collect(Collectors.joining(" "));
        System.out.println("Operation: "+ operation);
        System.out.println(result);
        System.out.println();
        System.out.println();
    }

    /**
     *                                           8
     *                                    /             \
     *                                  4                 18
     *                              /       \          /      \
     *                            2         6         11      23
     *                          /   \     /   \     /   \    /  \
     *                        1     3   5     7   9     13  22  27
     */
    private static TNode newInitTree() {
        TNode rootNode = new TNode(8);
        TNode node4 = new TNode(4);
        rootNode.left = node4;
        TNode node18 = new TNode(18);
        rootNode.right = node18;
        TNode node2 = new TNode(2);
        TNode node6 = new TNode(6);
        node4.left = node2;
        node4.right = node6;
        TNode node11 = new TNode(11);
        TNode node23 = new TNode(23);
        node18.left = node11;
        node18.right = node23;
        TNode node1 = new TNode(1);
        TNode node3 = new TNode(3);
        node2.left = node1;
        node2.right = node3;
        TNode node5 = new TNode(5);
        TNode node7 = new TNode(7);
        node6.left = node5;
        node6.right = node7;
        TNode node9 = new TNode(9);
        TNode node13 = new TNode(13);
        node11.left = node9;
        node11.right = node13;
        TNode node22 = new TNode(22);
        TNode node27 = new TNode(27);
        node23.left = node22;
        node23.right = node27;
        return rootNode;
    }
}
