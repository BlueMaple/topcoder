package com.leetcode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		int[] res = new int[1];
		sum(root, "", res);
		return res[0];
	}

	private void sum(TreeNode node, String s, int[] res) {
		if (node != null) {
			s += node.val;
			if (node.left != null || node.right != null) {
				sum(node.left, s, res);
				sum(node.right, s, res);
			}else{
				int value = Integer.parseInt(s);
				res[0] += value;
			}
		}
	}
}
