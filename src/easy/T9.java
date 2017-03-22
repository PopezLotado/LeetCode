package easy;

/**
 * @Title Palindrome Number
 * @Description Determine whether an integer is a palindrome. Do this without
 *              extra space.
 * 
 *              Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 *              If you are thinking of converting the integer to string, note
 *              the restriction of using extra space.
 * 
 *              You could also try reversing an integer. However, if you have
 *              solved the problem "Reverse Integer", you know that the reversed
 *              integer might overflow. How would you handle such case?
 * 
 *              There is a more generic way of solving this problem.
 * @author Potato
 *
 */
public class T9 {

	public static void main(String[] args) {
		T9 t9=new T9();
		System.out.println(t9.isPalindrome(101));
	}
	
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
        int l=1;
        int t=x;
        while(t>9){
        	l*=10;
        	t/=10;
        }
        while(l>1){
        	if(x/l != x%10)
        		return false;
        	x=x%l;
        	x=x/10;
        	l/=100;
        }
        return true;
        
        // best solution
//        if (x<0 || (x!=0 && x%10==0)) return false;
//        int rev = 0;
//        while (x>rev){
//        	rev = rev*10 + x%10;
//        	x = x/10;
//        }
//        return (x==rev || x==rev/10);
    }

}
