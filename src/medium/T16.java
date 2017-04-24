package medium;

import java.util.Arrays;

/**
 * @Title 3Sum Closest
 * @Description Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author Potato
 *
 */
public class T16 {

	public static void main(String[] args) {

	}

    public int threeSumClosest(int[] nums, int target) {
    	int res=0;
        if(nums.length<=3){
        	for(int i=0;i<nums.length;i++)
        		res+=nums[i];
        	return res;
        }
        Arrays.sort(nums);
        res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
        	int l=i+1;
        	int h=nums.length-1;
        	while(l<h){
        		int t=nums[i]+nums[l]+nums[h];
        		if(Math.abs(target-t) < Math.abs(target-res))
        			res=t;
        		if(t==target)
        			return t;
        		if(t>target)
        			h--;
        		else
        			l++;
        	}
        }
        return res;
    }
}
