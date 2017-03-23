package medium;

import util.Util;

/**
 * @Title Maximum Product Subarray
 * @Description Find the contiguous subarray within an array (containing at
 *              least one number) which has the largest product.
 * 
 *              For example, given the array [2,3,-2,4], the contiguous subarray
 *              [2,3] has the largest product = 6.
 * @author Potato
 *
 */
public class T152 {

	public static void main(String[] args) {
		T152 t152=new T152();
		System.out.println(t152.maxProduct(new int[]{2,3,-2,4}));
	}
	/**
	 * 超时.....
	 * @param nums
	 * @return
	 */
    public int maxProduct(int[] nums) {
    	int res=Integer.MIN_VALUE;
    	int n=nums.length;
        int dp[][]=new int [n][n];
        for(int i=0;i<n;i++){
        	dp[i][i]=nums[i];
        	res=Math.max(res, dp[i][i]);
        }
        for(int l=1;l<n;l++){
        	for(int i=0;i<n-l;i++){
        		dp[i][i+l]=dp[i][i]*dp[i+1][i+l];
        		res=Math.max(res, dp[i][i+l]);
        	}
        }
        //Util.print(dp);
        return res;
    }
    
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

}
