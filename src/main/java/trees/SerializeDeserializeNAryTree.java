package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://java2blog.com/serialize-deserialize-n-ary-tree/
 */
public class SerializeDeserializeNAryTree {
    private static class Node {
        private int value;
        private ArrayList<Node> children;

        Node(int value) {
            this.value = value;
            children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        Node child1Root = new Node(2);
        Node subChild1_1 = new Node(5);
        Node subChild1_2 = new Node(6);
        child1Root.children.add(subChild1_1);
        child1Root.children.add(subChild1_2);

        root.children.add(child1Root);

        Node child2Root = new Node(3);
        root.children.add(child2Root);

        Node child3Root = new Node(4);
        Node child3_subchild1 = new Node(7);
        Node child3_subchild2 = new Node(8);
        Node child3_subchild2_child1 = new Node(9);
        child3_subchild2.children.add(child3_subchild2_child1);

        child3Root.children.add(child3_subchild1);
        child3Root.children.add(child3_subchild2);

        root.children.add(child3Root);

        StringBuilder str = new StringBuilder();
        serialize(root, str);
        System.out.println("Serialized Tree : \n" + str);

        Node root2 = deserialize(str);

        System.out.println(root2);
    }

    private static void serialize(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.value);
            for (Node child : root.children) {
                serialize(child, sb);
                sb.append(";");
            }
        }
    }

    private static Node deserialize(StringBuilder sb) {
        char[] chars = new char[sb.length()];
        sb.getChars(0, sb.length(), chars, 0);
        Stack<Node> stk = new Stack<>();
        for (char ch : chars) {
            if (ch == ';') {
                Node child = stk.pop();
                Node parent = stk.peek();
                parent.children.add(child);
            } else {
                int ele = Integer.parseInt(Character.toString(ch));
                Node node = new Node(ele);
                stk.push(node);
            }
        }
        return stk.pop();
    }
}
