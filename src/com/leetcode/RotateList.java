package com.leetcode;
/**
 * n可能会大于这个链表的长度，需要取模计算
 * @author maple
 *
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i = 0;
		for (i = 0; fast.next != null; i++)
			// Get the total length
			fast = fast.next;

		for (int j = i - n % i; j > 0; j--)
			// Get the i-n%i th node
			slow = slow.next;

		fast.next = dummy.next; // Do the rotation
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}

}
