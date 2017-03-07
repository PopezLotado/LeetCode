package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title Intersection of Two Arrays II
 * @Description Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * @author Potato
 *
 */
public class T350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
        	int [] t=nums1;
        	nums1=nums2;
        	nums2=t;
        }
        /** Top Solution
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }
    
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
       return r;
       */
        List<Integer> n2List=new ArrayList<Integer>();
        for (int i : nums2) {
			n2List.add(i);
		}
        Set<Integer> junk=new HashSet<Integer>();
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
        	if(junk.contains(nums1[i]))
        		continue;
        	int k=0;
        	if(n2List.size()==0) break;
        	for(;k<n2List.size();k++){
        		if(nums1[i]==n2List.get(k)){
        			n2List.remove(k);
        			res.add(nums1[i]);
        			break;
        		}
        	}
        	if(k==n2List.size())
        		junk.add(nums1[i]);
        }
        int [] r=new int[res.size()];
        for (int i=0;i<r.length;i++) {
			r[i]=res.get(i);
		}
        return r;
    }

}
