package com.algorithms;

public class QuickSort {
	public void quickSort(int[] s) {
		int length = s.length;

		sort(s, 0, length - 1);
	}

	private void sort(int[] s, int l, int r) {
		if(l >= r)
			return;
		int i = l;
		int j = r;
		int x = s[l];

		while (i < j) {
			while (i < j && s[j] > x)
				j--;
			if (i < j)
				s[i++] = s[j];
			while (i < j && s[i] < x)
				i++;
			if (i < j)
				s[j--] = s[i];
		}

		s[i] = x;
		sort(s, l, i - 1);
		sort(s, i + 1, r);
	}

}
