package easy;


public class T1 {

	public static int[] twoSum(int[] nums, int target) {
		  for(int i=0;i<nums.length;i++){
			  int t=target-nums[i];
			  for(int k=i+1;k<nums.length;k++){
				  if(nums[k]==t)
				  {
					  int [] result={i,k};
					  return result;
				  }
			  }
		  }
          return null;
	}

	public static void main(String[] args) {
          int t[]={3,2,4};
          int r[]=twoSum(t, 6);
          for (int i : r) {
			System.out.println(i);
		}
	}
}
