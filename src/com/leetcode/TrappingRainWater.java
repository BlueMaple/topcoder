package com.leetcode;

import java.util.Stack;

/**
 * 观察下就可以发现**被水填满后的形状**是先升后降的塔形。
 * 因此，先遍历一遍找到塔顶，然后分别从两边开始，往塔顶所在位置遍历，水位只会增高不会减小，
 * 且一直和最近遇到的最大高度持平，这样知道了实时水位，就可以边遍历边计算面积。
 * 
 * @author maple
 * 
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length < 3)
			return 0;

		int ans = 0;
		int l = 0, r = height.length - 1;

		// find the left and right edge which can hold water
		while (l < r && height[l] <= height[l + 1])
			l++;
		while (l < r && height[r] <= height[r - 1])
			r--;

		while (l < r) {
			int left = height[l];
			int right = height[r];
			if (left <= right) {
				// add volum until an edge larger than the left edge
				while (l < r && left >= height[++l]) {
					ans += left - height[l];
				}
			} else {
				// add volum until an edge larger than the right volum
				while (l < r && right >= height[--r]) {
					ans += right - height[r];
				}
			}
		}
		return ans;
	}
}
