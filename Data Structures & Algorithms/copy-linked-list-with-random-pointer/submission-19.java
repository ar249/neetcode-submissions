/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while(cur != null)
        {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }


        cur = head;
        while(cur != null)
        {
            Node temp = map.get(cur);
            temp.next = map.get(cur.next);
            temp.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
