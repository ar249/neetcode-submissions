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
       ListNode t1 = head;
       ListNode t2 = dummy;
       int l = 0;

       while(t1 != null)
       {
        t1 = t1.next;
        l++;
       }

       for(int i = 0; i<l-n; i++)
       {
          t2 = t2.next;
       }

       t2.next = t2.next.next;

       return dummy.next;

       
    }
}
