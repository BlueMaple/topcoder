package com.algorithms;

public class MergeSort {
	public void sort(int[] s) {
		int length = s.length;

		sort(s, 0, length - 1);
	}

	private void sort(int[] s, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(s, l, m);
			sort(s, m + 1, r);

			merge(s, l, m, r);
		}
	}

	private void merge(int[] s, int l, int m, int r) {
		int nl = m - l + 1;
		int nr = r - m;

		int[] L = new int[nl];
		int[] R = new int[nr];
		for (int i = l; i <= r; i++) {
			if (i <= m)
				L[i - l] = s[i];
			else
				R[i - m - 1] = s[i];
		}
		int p = 0;
		int q = 0;
		for (int index = l; index <= r; index++) {
			if (p < nl && q < nr) {
				s[index] = L[p] < R[q] ? L[p++] : R[q++];
			}
			else{
				if(p < nl)
					s[index] = L[p++];
				if(q < nr)
					s[index] = R[q++];
			}
		}
	}
}
