package com.leetcode;

public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		ListNode secondPre = null;

		int index = 1;
		while (first != null) {
			if (index <= n) {
				first = first.next;
				index++;
			} else {
				secondPre = second;
				second = second.next;
				first = first.next;
			}
		}
		if (secondPre == null) {
			head = second.next;
		} else {
			secondPre.next = second.next;
		}
		return head;
	}

}
