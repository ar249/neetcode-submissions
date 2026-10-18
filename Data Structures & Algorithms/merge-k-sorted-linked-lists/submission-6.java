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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode ln : lists) {
            if (ln != null) {
                pq.offer(ln);
            }
        }

        ListNode temp = new ListNode();
        ListNode cur = temp;

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;

            if (n.next != null) {
                pq.offer(n.next);
            }
        }

        return temp.next;
    }
}
