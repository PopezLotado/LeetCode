package easy;

/**
 * @Title Arranging Coins
 * @Description You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
 * @author Potato
 *
 */
public class T441 {

	public static void main(String[] args) {
		T441 t441=new T441();
		System.out.println(t441.arrangeCoins(1804289383));
	}

	public int arrangeCoins(int n) {
        int x= (int)Math.floor((-1+Math.sqrt(1+8l*n))/2); //8.0*n 或 8l*n 保证不溢出
        return x;
    }
}
