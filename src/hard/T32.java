package hard;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Title Longest Valid Parentheses
 * @Description Given a string containing just the characters '(' and ')', find
 *              the length of the longest valid (well-formed) parentheses
 *              substring.
 * 
 *              For "(()", the longest valid parentheses substring is "()",
 *              which has length = 2.
 * 
 *              Another example is ")()())", where the longest valid parentheses
 *              substring is "()()", which has length = 4.
 * @author Potato
 *
 */
public class T32 {

	public static void main(String[] args) {
		T32 t32=new T32();
		System.out.println(t32.longestValidParentheses("()())"));
	}

	public int longestValidParentheses(String s) {
	    int max = 0;
	    Stack<Integer> stack = new Stack<>();
	    for(int i = 0; i <= s.length(); i++){
	        if(i<s.length() && s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek())== '(')
	            stack.pop();
	        else{
	            if(stack.empty()){
	                max = Math.max(max, i);
	            }
	            else
	                max = Math.max(max, i-stack.peek()-1);
	            stack.push(i);
	        }
	    }
	    return max;
	}
}
