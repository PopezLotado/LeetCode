package medium;

/**
 * @Title Search a 2D Matrix II
 * @Description Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 * @author Potato
 *
 */
public class T240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix={{1,3,5,7,8,9},
						 {2,4,6,8,9,11},
						 {3,7,8,9,13,14},
						 {10,11,12,13,14,17},
						 {15,16,18,19,20,22}};
		T240 t240=new T240();
		System.out.println(t240.searchMatrix(matrix, 15));
	}
	int[][] mat;
	int target;
	public boolean searchMatrix(int[][] matrix, int target) {
			mat=matrix;
			this.target=target;
	        int rows=matrix.length;
	        if(rows==0) return false;
	        int cols=matrix[0].length;
	        if(cols==0) return false;
	        return reduce(0,0,rows-1,cols-1);
	}

	private boolean reduce(int rowStart, int colStart, int rowEnd, int colEnd) {
		int l=rowStart,h=rowEnd;
        while(l<=h){
        	int mid=(l+h)/2;
        	if(mat[mid][colStart]==target)
        		return true;
        	else if(mat[mid][colStart]<target)
        		l=mid+1;
        	else
        		h=mid-1;
        }
        int maxRow=h;
        l=rowStart;
        h=rowEnd;
        while(l<=h){
        	int mid=(l+h)/2;
        	if(mat[mid][colEnd]==target)
        		return true;
        	else if(mat[mid][colEnd]<target)
        		l=mid+1;
        	else
        		h=mid-1;
        }
        int minRow=l;
        if(minRow>maxRow)
        	return false;
		int maxCol,minCol;
		l=colStart;
		h=colEnd;
        while(l<=h){
        	int mid=(l+h)/2;
        	if(mat[rowStart][mid]==target)
        		return true;
        	else if(mat[rowStart][mid]<target)
        		l=mid+1;
        	else
        		h=mid-1;
        }
		maxCol=h;
		
		l=colStart;
		h=colEnd;
        while(l<=h){
        	int mid=(l+h)/2;
        	if(mat[rowEnd][mid]==target)
        		return true;
        	else if(mat[rowEnd][mid]<target)
        		l=mid+1;
        	else
        		h=mid-1;
        }
		minCol=l;
		if(minCol>maxCol)
        	return false;
		return reduce(minRow, minCol, maxRow, maxCol);
	}
}
