/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    //根据题目限制可以直接开一个数组作为HashSet，运行表现更好一点
    public int numComponents(ListNode head, int[] G) {
        boolean[] set = new boolean[10000];
        for(Integer i : G) {
            set[i] =  true;
        }

        int ret = 0;
        ListNode p = head;
        while (p != null ) {
            if (set[p.val]) {
                while (p.next!=null && set[p.val]) {
                    p = p.next;
                }
                ret++;
            }
            p = p.next;
        }

        return ret;
    }
    
    
    //其他参考：使用HaseSet
    public int numComponents2(ListNode head, int[] G) {
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
