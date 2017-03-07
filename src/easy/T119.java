package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Pascal's Triangle II
 * @Description Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * @author Potato
 *
 */
public class T119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T119 t119=new T119();
		List<Integer> list=t119.getRow(4);
		list.forEach(System.out::println);
	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res=new ArrayList<Integer>();
		res.add(1);
        for(int i=1;i<=rowIndex;i++){
        	res.add(1);
        	for(int j=i-1;j>=1;j--){
        		res.set(j, res.get(j-1)+res.get(j));
        	}
        }
        return res;
    }

}
