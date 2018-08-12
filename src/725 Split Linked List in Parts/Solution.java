/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] ret = new ListNode[k];

		if (null == root) {
			return ret;
		}

		int length = 0;
		ListNode p = root;
		while (p != null) {
			length++;
			p = p.next;
		}

		//每一组m个,前n组m+1个
		int m = length / k;
		int n = length % k;

		for (int i = 0; i < k; ++i) {
			if (root = null) {
				continue;
			}
			ListNode curHead = root;
			int curLength = i < n ? m + 1 : m;
			ListNode cur = curHead;
			for (int j = 0; j < curLength - 1; j++) {
				cur = cur.next;
			}
			root = cur.next;
			cur.next = null;
			ret[i] = curHead;
		}
		return ret;

	}
}