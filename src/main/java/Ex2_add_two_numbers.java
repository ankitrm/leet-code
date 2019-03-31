import utils.ListNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Ex2_add_two_numbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);
    //l1.next.next.next = new ListNode(7);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode newNodes = addTwoNumbers(l1, l2);
    while (newNodes != null) {
      System.out.println(newNodes.val);
      newNodes = newNodes.next;
    }
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode temp = new ListNode(0);
    ListNode result = temp;
    int carry = 0;
    while (l1 != null || l2 != null || carry !=0) {
      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0: l2.val) + carry;
      carry = sum / 10;
      int remainder = sum % 10;
      ListNode node = new ListNode(remainder);
      temp.next = node;
      temp = node;

      l1 = l1 == null? null: l1.next;
      l2 = l2 == null? null: l2.next;
    }
    return result.next;
  }
















  /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode temp = new ListNode(0);
    ListNode root = temp;
    while(l1 != null || l2 != null || carry != 0) {
      int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
      int remainder = sum % 10;
      carry = sum / 10;

      ListNode newNode = new ListNode(remainder);
      temp.next = newNode;
      temp = newNode;

      l1 = l1 == null? null : l1.next;
      l2 = l2 == null? null : l2.next;
    }
    return root.next;
  }*/
}
