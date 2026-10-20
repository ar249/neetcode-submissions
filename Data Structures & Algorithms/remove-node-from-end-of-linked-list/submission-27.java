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
        ListNode temp = new ListNode(0, head);
        ListNode cur = temp;

        int l=0;
        while(cur.next != null)
        {
            cur = cur.next;
            l++;
        }

        cur = temp;
        for(int i = 0; i<l-n; i++)
        {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return temp.next;
    }
}
