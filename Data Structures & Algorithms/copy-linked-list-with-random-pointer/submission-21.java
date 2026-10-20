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
        Map<Node, Node> map = new HashMap<>();

        if(head == null)
        {
            return null;
        }

        Node temp = head;

        while(temp != null)
        {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null)
        {
            Node m = map.get(temp);
            m.next = map.get(temp.next);
            m.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
