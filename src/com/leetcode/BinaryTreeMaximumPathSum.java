package com.leetcode;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		
		calMaxSum(root, res);
        return 0;
    }

	private int calMaxSum(TreeNode node, int[] res) {
		if(node != null){
			int left = Math.max(0, calMaxSum(node.left, res));
			int right = Math.max(0, calMaxSum(node.right, res));
			
			res[0] = Math.max(res[0], left+node.val+right);
			
			return Math.max(left, right)+node.val;
		}
		
		return 0;
	}
}
