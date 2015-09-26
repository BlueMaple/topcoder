package com.leetcode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode oneStep = head;
		ListNode twoStep = head;

		while (twoStep != null && oneStep != null) {
			oneStep = oneStep.next;
			twoStep = twoStep.next;
			if (twoStep != null) {
				twoStep = twoStep.next;
			}
			if (twoStep == null) {
				break;
			}

			if (oneStep.val == twoStep.val && oneStep.next == twoStep.next) {
				return true;
			}
		}

		return false;
	}

}
