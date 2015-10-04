package com.leetcode;

public class ConstructBinaryTreeInPost {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(postorder.length - 1, 0, inorder.length - 1, postorder,
				inorder);
	}

	private TreeNode build(int postStart, int inStart, int inEnd,
			int[] postorder, int[] inorder) {
		if (postStart < 0 || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postStart]);
		int inRootIndex = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postStart]) {
				inRootIndex = i;
				break;
			}
		}
		root.left = build(postStart - (inEnd - inRootIndex + 1), inStart,
				inRootIndex - 1, postorder, inorder);
		root.right = build(postStart - 1, inRootIndex + 1, inEnd, postorder,
				inorder);
		return root;
	}
}
