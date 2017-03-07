package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @Title Random Pick Index
 * 
 * @Description Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
 *
 */
public class T398 {

	int nums[];
	List<Integer> save;
	Random random=new Random();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public T398(int[] nums) {
        this.nums=nums;
        save=new ArrayList<Integer>();
    }
    
    public int pick(int target) {
    	save.clear();
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==target)
        		save.add(i);
        }
        int r=random.nextInt(save.size());
        return save.get(r);
    }

}
