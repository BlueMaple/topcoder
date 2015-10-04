package com.leetcode;

public class ConstructBinaryTreePreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode build(int preStart, int inStart, int inEnd,
			int[] preorder, int[] inorder) {
		if (preStart >= preorder.length || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int inRootIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val)
				inRootIndex = i;
		}

		root.left = build(preStart + 1, inStart, inRootIndex - 1, preorder,
				inorder);
		root.right = build(preStart + (inRootIndex - inStart + 1),
				inRootIndex + 1, inEnd, preorder, inorder);
		return root;
	}
}
