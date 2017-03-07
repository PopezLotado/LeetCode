package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title 3Sum
 * @Description Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author Potato
 *
 */
public class T15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={-2,10,-14,11,5,-4,2,0,-10,-10,5,7,-11,10,-2,-5,2,12,-5,14,-11,-15,-5,12,0,13,8,7,10,6,-9,-15,1,14,11,-9,-13,-10,6,-8,-5,-11,6,-9,14,11,-7,-6,8,3,-7,5,-5,3,2,10,-6,-12,3,11,1,1,12,10,-8,0,8,-5,6,-8,-6,8,-12,-14,7,9,12,-15,-12,-2,-4,-4,-12,6,7,-3,-6,-14,-8,4,4,9,-10,-7,-4,-3,1,11,-1,-8,-12,9,7,-9,10,-1,-14,-1,-8,11,12,-5,-7};
		T15 t15=new T15();
		long s=System.currentTimeMillis();
		t15.threeSum(nums);
		System.out.println(System.currentTimeMillis()-s);
	}
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		Set<String> set=new HashSet<String>();
        for(int i=0;i<nums.length-2;i++){
        	for(int j=i+1;j<nums.length-1;j++){
        		for(int k=j+1;k<nums.length;k++){
        			if(nums[i]+nums[j]+nums[k]==0){
        				List<Integer> list=new ArrayList<Integer>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(nums[k]);
        				Collections.sort(list);
        				String key="";
        				for (Integer integer : list) {
							key+=integer+",";
						}
        				if(!set.contains(key)){
        					System.out.println(key);
        					set.add(key);
        					res.add(list);
        				}
        			}
        		}
        	}
        }
        return res;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		int last=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
        	if(nums[i]==last) continue;
        	if(nums[i]>0) break;
        	int l=i+1;
        	int h=nums.length-1;
        	int rest=0-nums[i];
        	while(l<h){
        		int s=nums[l]+nums[h];
        		if(s==rest){
        			List<Integer> list=Arrays.asList(nums[i],nums[l],nums[h]);
        			res.add(list);
        			while(l<h && nums[l]==nums[l+1]) l++;
        			while(l<h && nums[h]==nums[h-1]) h--;
        			l++;
        			h--;
        		}else if(s>rest) h--;
        		else {
					l++;
				}
        	}
        	last=nums[i];
        }
        return res;
    }

}
