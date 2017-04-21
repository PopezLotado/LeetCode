package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Flatten Nested List Iterator
 * @Description Given a nested list of integers, implement an iterator to
 *              flatten it.
 * 
 *              Each element is either an integer, or a list -- whose elements
 *              may also be integers or other lists.
 * 
 *              Example 1: Given the list [[1,1],2,[1,1]],
 * 
 *              By calling next repeatedly until hasNext returns false, the
 *              order of elements returned by next should be: [1,1,2,1,1].
 * 
 *              Example 2: Given the list [1,[4,[6]]],
 * 
 *              By calling next repeatedly until hasNext returns false, the
 *              order of elements returned by next should be: [1,4,6].
 * @author Potato
 *
 */
public class T341 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
//interface NestedInteger {
//	public boolean isInteger();
//
//	public Integer getInteger();
//
//	public List<NestedInteger> getList();
//}

class NestedIterator implements Iterator<Integer> {

	List<Integer> flattened;
	int current=0;
	public NestedIterator(List<NestedInteger> nestedList) {
		flattened=flatten(nestedList);
	} 
	
	public List<Integer> flatten(List<NestedInteger> nestedList){
		List<Integer> res=new LinkedList<Integer>();
		for (NestedInteger nestedInteger : nestedList) {
			if(nestedInteger.isInteger())
				res.add(nestedInteger.getInteger());
			else
				res.addAll(flatten(nestedInteger.getList()));
		}
		return res;
	}

	@Override
	public Integer next() {
		return flattened.get(current++);
	}

	@Override
	public boolean hasNext() {
		return current<flattened.size();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */

//public class NestedIterator implements Iterator<Integer> {
//    Stack<NestedInteger> stack = new Stack<>();
//    public NestedIterator(List<NestedInteger> nestedList) {
//        for(int i = nestedList.size() - 1; i >= 0; i--) {
//            stack.push(nestedList.get(i));
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return stack.pop().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while(!stack.isEmpty()) {
//            NestedInteger curr = stack.peek();
//            if(curr.isInteger()) {
//                return true;
//            }
//            stack.pop();
//            for(int i = curr.getList().size() - 1; i >= 0; i--) {
//                stack.push(curr.getList().get(i));
//            }
//        }
//        return false;
//    }
//}
