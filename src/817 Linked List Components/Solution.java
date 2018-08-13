/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }

        int ret = 0;
        ListNode p = head;
        while (p != null) {
            if (set.contain(p.val)) {
                while (p != null && set.contain(p.val)) {
                    p = p.next;
                }
                ret++;
            }
            p = p.next;
        }

        return ret;
    }
}
