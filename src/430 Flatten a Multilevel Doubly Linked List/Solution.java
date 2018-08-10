/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();

        if(null == head) {
            return head;
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        stack.push(head);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            if(cur.next != null) {
                stack.push(cur.next);
            }
            if(cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            tail.next = cur;
            cur.prev = tail;
            tail = tail.next;
        }

        Node ret = dummy.next;
        ret.prev = null;
        dummy.next = null;
        return ret;
    }
}