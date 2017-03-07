package medium;

/**
 * @Title Spiral Matrix II
 * @Description Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author Potato
 *
 */
public class T59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T59 t59=new T59();
		int n=2;
		int res[][]=t59.generateMatrix(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(res[i][j]+ " ");
			System.out.println();
		}
	}
	public int[][] generateMatrix(int n) {
		if(n==0) return new int[][]{};;
		if(n==1) return new int[][]{{1}};
        int current=1;
        int direction=0;
        int col=-1,row=0;
        int res[][]=new int[n][n];
        boolean isFinished=false;
        while(!isFinished){
        	switch (direction) {
			case 0:
				if(res[row][col+1]!=0)
					isFinished=true;
				col++;
				while(col<n && res[row][col]==0){
					res[row][col++]=current;
					current++;
				}
				col--;
				break;
			case 1:
				if(res[row+1][col]!=0)
					isFinished=true;
				row++;
				while(row<n && res[row][col]==0){
					res[row++][col]=current;
					current++;
				}
				row--;
				break;
			case 2:
				if(res[row][col-1]!=0)
					isFinished=true;
				col--;
				while(col>=0 && res[row][col]==0){
					res[row][col--]=current;
					current++;
				}
				col++;
				break;
			case 3:
				if(res[row-1][col]!=0)
					isFinished=true;
				row--;
				while(row<n && res[row][col]==0){
					res[row--][col]=current;
					current++;
				}
				row++;
				break;
			default:
				break;
			}
        	direction=(direction+1)%4;
        }
        return res;
    }

}
