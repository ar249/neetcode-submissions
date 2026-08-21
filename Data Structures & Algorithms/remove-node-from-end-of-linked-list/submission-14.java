/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0, head);

      ListNode t1 = dummy;
      ListNode t2 = dummy;

      for(int i = 0; i<n; i++)
      {
         t2 = t2.next;
      }

      while(t2.next != null)
      {
         t1 = t1.next;
         t2 = t2.next;
      } 

      t1.next = t1.next.next;

      return dummy.next;
    }
}
