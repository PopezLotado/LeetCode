package hard;

/**
 * @Title Trapping Rain Water
 * @Description Given n non-negative integers representing an elevation map
 *              where the width of each bar is 1, compute how much water it is
 *              able to trap after raining.
 * 
 *              For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author Potato
 *
 */
public class T42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T42 t42=new T42();
		System.out.println(t42.trap(new int[]{0,1,0,2,1,0,1,3,0,0,0,1}));
	}

	public int trap(int[] height) {
		int res=0;
		int p=0;
		while(p<height.length && height[p]==0)
			p++;
		while(p<height.length){
			int s=p;
			int left=height[p++];
			int n=0;
			int rp=p;
			int rm=-1;
			while(p<height.length && height[p]<left){
				if(height[p]>rm){
					rp=p;
					rm=height[p];
				}
				n+=left-height[p];
				p++;
			}
			if(p<height.length)
				res+=n;
			else{
				n=0;
				for(int i=s+1;i<rp;i++){
					n+=rm-height[i];
				}
				res+=n;
				p=rp;
			}
		}
		return res;
	}

}
