package medium;

import java.util.List;

/**
 * @Title Mini Parser
 * @Description Given a nested list of integers represented as a string,
 *              implement a parser to deserialize it.
 * 
 *              Each element is either an integer, or a list -- whose elements
 *              may also be integers or other lists.
 * 
 *              Note: You may assume that the string is well-formed:
 * 
 *              String is non-empty. String does not contain white spaces.
 *              String contains only digits 0-9, [, - ,, ]. Example 1:
 * 
 *              Given s = "324",
 * 
 *              You should return a NestedInteger object which contains a single
 *              integer 324. Example 2:
 * 
 *              Given s = "[123,[456,[789]]]",
 * 
 *              Return a NestedInteger object containing a nested list with 2
 *              elements:
 * 
 *              1. An integer containing value 123. 2. A nested list containing
 *              two elements: i. An integer containing value 456. ii. A nested
 *              list with one element: a. An integer containing value 789.
 * @author Potato
 *
 */
public class T385 {

	public static void main(String[] args) {

	}

	public NestedInteger deserialize(String s) {
		NestedInteger res=new NestedInteger();
		int b=0;
		boolean isDigit=false;
		int flag=1;
		boolean isList= s.charAt(0)=='[';
		int p=isList?1:0;
		int end=isList?s.length()-1:s.length();
		while(p<end){
			char c=s.charAt(p);
			if(c=='['){
				int start=p;
				p++;
				int g=1;
				while(g!=0){
					if(s.charAt(p)=='[')
						g++;
					else if(s.charAt(p)==']')
						g--;
					p++;
				}
				res.add(deserialize(s.substring(start, p)));
			}else if(c==','){
				NestedInteger ni=new NestedInteger();
				ni.setInteger(flag*b);
				b=0;
				flag=1;
				isDigit=false;
				res.add(ni);
			}else if(c=='-'){
				flag=-1;
			}else {
				b=b*10+s.charAt(p)-'0';
				isDigit=true;
			}
			p++;
		}
		if(isDigit){
			if(isList){
				NestedInteger ni=new NestedInteger();
				ni.setInteger(flag*b);
				res.add(ni);
			}else
				res.setInteger(flag*b);
		}
		return res;
	}
}

// This is the interface that allows for creating nested lists. // You should
// not implement it, or speculate about its implementation
class NestedInteger { // Constructor initializes an empty nested list. public
	NestedInteger() {
	}
	// Constructor initializes a single integer. public NestedInteger(int
	// value);

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return false;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return null;
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public void add(NestedInteger ni) {
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}