package hard;

public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T4 t4 = new T4();
		int nums1[] = { 1,2 };
		int nums2[] = { 1,1};
		System.out.println(t4.findMedianSortedArrays(nums1, nums2));
		//int c=(nums1.length + nums2.length - 1) / 2;
		//System.out.println(t4.binarySearch(nums1, nums2, 0, nums1.length-1, c+1));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int c=(nums1.length + nums2.length - 1) / 2;
		if((nums1.length+nums2.length-1)%2==0) // 一个中位数
			return binarySearch(nums1, nums2, 0, nums1.length - 1, c);
		else  //先找低中位数 再找高中位数
			return (binarySearch(nums1, nums2, 0, nums1.length - 1, c)+binarySearch(nums1, nums2, 0, nums1.length - 1, c+1))/2;
	}

	public double binarySearch(int[] nums1, int[] nums2, int l, int h, int c) {
		int mid = (l + h) / 2;
		if (l > h)
			return binarySearch(nums2, nums1, 0, nums2.length - 1, c);
		int r = c - mid;
		if (r - 1 > nums2.length - 1 || (r-1 >=0 && nums1[mid] < nums2[r - 1]))
			return binarySearch(nums1, nums2, mid + 1, h, c);
		else if (r < 0 || (r<nums2.length && nums1[mid] > nums2[r]))
			return binarySearch(nums1, nums2, l, mid - 1, c);
		else 
			return nums1[mid] * 1.0;
	}
}
