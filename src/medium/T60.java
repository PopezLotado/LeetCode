package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Permutation Sequence
 * @Description The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 *              By listing and labeling all of the permutations in order, We get
 *              the following sequence (ie, for n = 3):
 * 
 *              "123" "132" "213" "231" "312" "321" Given n and k, return the
 *              kth permutation sequence.
 * 
 *              Note: Given n will be between 1 and 9 inclusive.
 * @author Potato
 *
 */
public class T60 {

	public static void main(String[] args) {
		T60 t60 = new T60();
		System.out.println(t60.getPermutation(6, 5));
	}

	public String getPermutation(int n, int k) {
		int p[] = new int[n];
		p[0] = 1;
		List<Integer> data = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			p[i] = p[i - 1] * i;
			data.add(i);
		}
		data.add(n);
		return makeup(k, p, n - 1, data);
	}

	private String makeup(int k, int[] p, int i, List<Integer> data) {
		if (i == 0)
			return "" + data.get(0);
		//k--  
		//index=k/p[i];
		int index = k % p[i] == 0 ? k / p[i] - 1 : k / p[i];
		int t = data.get(index);
		data.remove(index);
		return t + makeup(k - index * p[i], p, i - 1, data);
	}

}
