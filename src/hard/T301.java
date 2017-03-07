package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Title Remove Invalid Parentheses
 * @Description Remove the minimum number of invalid parentheses in order to
 *              make the input string valid. Return all possible results.
 * 
 *              Note: The input string may contain letters other than the
 *              parentheses ( and ).
 * 
 *              Examples: "()())()" -> ["()()()", "(())()"] "(a)())()" ->
 *              ["(a)()()", "(a())()"] ")(" -> [""]
 * @author Potato
 *
 */
public class T301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T301 t301 = new T301();
		List<String> list = t301.removeInvalidParentheses(")(");
		list.forEach(System.out::println);
	}

	public List<String> removeInvalidParentheses(String s) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> checked = new HashSet<String>();
		List<String> res = new ArrayList<String>();
		queue.offer(s);
		boolean isFind = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String e = queue.poll();
				if (isValid(e)) {
					res.add(e);
					isFind = true;
				}
				if (isFind)
					continue;
				for (int i = 0; i < e.length(); i++) {
					if (e.charAt(i) == '(' || e.charAt(i) == ')') {
						String t = e.substring(0, i) + e.substring(i + 1);
						if (!checked.contains(t)) {
							queue.offer(t);
							checked.add(t);
						}
					}
				}
			}
			if (isFind)
				break;
		}
		return res;
	}

	public boolean isValid(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				c++;
			else if (s.charAt(i) == ')')
				c--;
			if (c < 0)
				break;
		}
		return c == 0;
	}

}
