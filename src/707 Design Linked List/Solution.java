class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > length - 1) {
            return -1;
        }
        Node p = head;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        length++;

        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        length++;

        Node node = new Node(val);
        if (this.length == 1) {
            head = node;
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }

        length++;
        Node node = new Node(val);
        Node p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        length--;
        if (index == 0) {
            head = head.next;
        }

        Node p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */