package hard;

/**
 * @Title Distinct Subsequences
 * @Description Given a string S and a string T, count the number of distinct
 *              subsequences of T in S.
 * 
 *              A subsequence of a string is a new string which is formed from
 *              the original string by deleting some (can be none) of the
 *              characters without disturbing the relative positions of the
 *              remaining characters. (ie, "ACE" is a subsequence of "ABCDE"
 *              while "AEC" is not).
 * 
 *              Here is an example: S = "rabbbit", T = "rabbit"
 * 
 *              Return 3.
 * @author Potato
 *
 */
public class T115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T115 t115=new T115();
		System.out.println(t115.numDistinct("rabbbit", "rabbit"));
	}

	public int numDistinct(String s, String t) {
		if (s == null || t == null) {
			return 0;
		}
		if (s.length() < t.length()) {
			return 0;
		}
		// 递推公式用的
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		// 任意一个字符串变换成一个空串都只有一种变换方法
		for (int i = 0; i < s.length(); i++) {
			dp[i][0] = 1;
		}
		// 递推公式
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				// 如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[s.length()][t.length()];
	}

}
