package easy;


/**
 * @Title Valid Perfect Square
 * @Description Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 * @author Potato
 *
 */
public class T367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T367 t367=new T367();
		System.out.println(t367.isPerfectSquare(2147483647));
		System.out.println(Long.MAX_VALUE);
		System.out.println((long)1100000000*1100000000);
	}
	public boolean isPerfectSquare(int num) {
		long l=1;
		long h=num;
		while(l<=h){
			long mid=(l+h)/2;
			if(mid*mid==num)
				return true;
			else if(mid*mid>num)
				h=mid-1;
			else {
				l=mid+1;
			}
		}
		return false;
    }

}
