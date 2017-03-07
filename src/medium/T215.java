package medium;

import java.util.Random;

/**
 * @Title Kth Largest Element in an Array
 * @Description Find the kth largest element in an unsorted array. Note that it
 *              is the kth largest element in the sorted order, not the kth
 *              distinct element.
 * 
 *              For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 *              Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author Potato
 *
 */
public class T215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	public int findKthLargest(int[] nums, int k) {
//		int n=nums.length;
//		for(int i=0;i<k;i++){
//			for(int j=0;j<n-i-1;j++){
//				if(nums[j]>nums[j+1]){
//					int t=nums[j];
//					nums[j]=nums[j+1];
//					nums[j+1]=t;
//				}
//			}
//		}
//		return nums[n-k];
//	}
	private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
	
	public int findKthLargest(int[] nums, int k) {

		shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

}
