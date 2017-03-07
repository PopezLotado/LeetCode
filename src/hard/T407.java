package hard;

import java.util.PriorityQueue;

/**
 * @Title Trapping Rain Water II
 * @Description Given an m x n matrix of positive integers representing the
 *              height of each unit cell in a 2D elevation map, compute the
 *              volume of water it is able to trap after raining.
 * 
 *              Note: Both m and n are less than 110. The height of each unit
 *              cell is greater than 0 and is less than 20,000.
 * 
 *              Example:
 * 
 *              Given the following 3x6 height map: [ [1,4,3,1,3,2],
 *              [3,2,1,3,2,4], [2,3,3,2,3,1] ]
 * 
 *              Return 4.
 * @author Potato
 *
 */
public class T407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trapRainWater(int[][] heightMap) {
		if(heightMap==null || heightMap.length<=2 || heightMap[0].length<=2)
			return 0;
		int rows=heightMap.length;
		int cols=heightMap[0].length;
		int res=0;
		boolean [][] visited=new boolean[rows][cols];
		PriorityQueue<Cell> queue=new PriorityQueue<>();
		for(int i=0;i<rows;i++){
			visited[i][0]=true;
			visited[i][cols-1]=true;
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			queue.offer(new Cell(i, cols-1, heightMap[i][cols-1]));
		}
		for(int i=1;i<cols-1;i++){
			visited[0][i]=true;
			visited[rows-1][i]=true;
			queue.offer(new Cell(0, i, heightMap[0][i]));
			queue.offer(new Cell(rows-1, i, heightMap[rows-1][i]));
		}
		int xp[]=new int[]{-1,1,0,0};
		int yp[]=new int[]{0,0,-1,1};
		while(!queue.isEmpty()){
			Cell cell=queue.poll();
			for(int i=0;i<4;i++){
				int r=cell.row+xp[i];
				int c=cell.col+yp[i];
				if(r>=0 && r<rows && c>=0 && c<cols && !visited[r][c]){
					visited[r][c]=true;
					if(cell.height>heightMap[r][c]){
						res+=cell.height-heightMap[r][c];
						queue.offer(new Cell(r, c, cell.height));
					}else
						queue.offer(new Cell(r, c, heightMap[r][c]));
				}
			}
		}
		return res;
	}
	
	class Cell implements Comparable<Cell>{

		int row;
		int col;
		int height;
		public Cell(int r,int c,int h){
			row=r;
			col=c;
			height=h;
		}
		@Override
		public int compareTo(Cell o) {
			// TODO Auto-generated method stub
			return this.height-o.height;
		}
		
	}

}


