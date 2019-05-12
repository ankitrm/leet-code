import utils.ListNode;

import java.util.*;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class Ex143_Reorder_List {
    public static void main(String[] args) {
        ListNode head = ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int totalElements = stack.size();
        temp = head;
        for (int count = 0; count < totalElements / 2; count++, temp = temp.next) {
            stack.peek().next = temp.next;
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
    }
}
