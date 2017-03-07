package easy;

/**
 * @Title Valid Palindrome
 * @Description Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @author Potato
 *
 */
public class T125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T125 t125=new T125();
		System.out.println(t125.isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public boolean isPalindrome(String s) {
        s=s.replaceAll("\\W", ""); //等效于 [^A-Za-z0-9]
        if(s.isEmpty())
        	return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
        	if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
        		return false;
        	i++;
        	j--;
        }
		return true;
    }

}
