package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Find All Duplicates in an Array
 * @Description Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * @author Potato
 *
 */
public class T442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        while(i<n){
        	if(nums[i]==i+1){
        		i++;
        		continue;
        	}
        	int t=nums[i];
        	nums[i]=-1;
        	while(nums[t-1]!=t){
        		int j=nums[t-1];
        		nums[t-1]=t;
        		t=j;
        		if(t==-1){
        			break;
        		}
        	}
        	if(t!=-1)
        		res.add(t);
            i++;
        }
        return res;
    }

}
