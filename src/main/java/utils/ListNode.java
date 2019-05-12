package utils;

import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public static ListNode create(List<Integer> list) {
    ListNode listNode = null;
    ListNode result = null;
    for (int ele : list) {
      if(listNode == null) {
        listNode = new ListNode(ele);
        result = listNode;
      } else {
        listNode.next = new ListNode(ele);
        listNode = listNode.next;
      }
    }
    return result;
  }
}
