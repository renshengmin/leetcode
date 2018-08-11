/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode evenHead = head.next;

        //遍历
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            evenPtr.next = evenPtr.next.next;
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;
        }

        oddPtr.next = evenHead;

        return dummy.next;
    }
}
