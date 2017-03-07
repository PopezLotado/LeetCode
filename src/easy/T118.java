package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Pascal's Triangle
 * @Description Given numRows, generate the first numRows of Pascal's triangle.
 * 
 *              For example, given numRows = 5, Return
 * 
 *              [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * @author Potato
 *
 */
public class T118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res=new ArrayList<>();
		for(int i=1;i<=numRows;i++){
			List<Integer> row=new ArrayList<>();
			for(int j=1;j<=i;j++){
				if(j==1 || j==i)
					row.add(1);
				else
					row.add(res.get(res.size()-1).get(j-2)+res.get(res.size()-1).get(j-1));
			}
			res.add(row);
		}
		return res;
	}

}
