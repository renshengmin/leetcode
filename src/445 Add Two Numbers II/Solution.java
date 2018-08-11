/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 * <p>
 * 445. Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) {
            return null == l1 ? l2 : l1;
        }
        if (l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);

        //计算链表长度
        int len1 = 0;
        for (ListNode p = l1; p != null; p = p.next) {
            len1++;
        }
        int len2 = 0;
        for (ListNode p = l2; p != null; p = p.next) {
            len2++;
        }

        //标记长短链表
        ListNode longPtr = l1;
        ListNode shortPtr = l2;
        int dis = 0;
        if (len1 > len2) {
            dis = len1 - len2;
        } else {
            longPtr = l2;
            shortPtr = l1;
            dis = len2 - len1;
        }

        //长链表头部先逆序插入到虚拟头结点后面
        for (int i = 0; i < dis; i++) {
            ListNode tmpHead = dummy.next;
            ListNode newNode = new ListNode(longPtr.val);
            newNode.next = tmpHead;
            dummy.next = newNode;
            longPtr = longPtr.next;
        }

        //对齐后开始执行加法
        while (shortPtr != null) {
            int curSum = (shortPtr.val + longPtr.val) % 10;
            int carry = (shortPtr.val + longPtr.val) / 10;
            if (carry > 0) {
                //处理进位
                ListNode pre = dummy;
                ListNode cur = pre.next;
                int newCarry = carry;
                while (cur != null && newCarry != 0) {
                    int newSum = (cur.val + newCarry) % 10;
                    newCarry = (cur.val + newCarry) / 10;
                    cur.val = newSum;
                    pre = cur;
                    cur = cur.next;
                }
                if (newCarry != 0) {
                    //最后还要补上一个
                    ListNode newNode = new ListNode(newCarry);
                    pre.next = newNode;
                }

            }
            //插入新节点
            ListNode tmpHead = dummy.next;
            ListNode newNode = new ListNode(curSum);
            dummy.next = newNode;
            newNode.next = tmpHead;

            longPtr = longPtr.next;
            shortPtr = shortPtr.next;
        }

        //将结果反转
        ListNode ret = dummy.next;
        dummy.next = null;
        return reverseList(ret);
    }

    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextTmp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = nextTmp;
        }

        return pre;
    }
}

