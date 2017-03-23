package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Regular Expression Matching
 * @Description Implement regular expression matching with support for '.' and
 *              '*'.
 * 
 *              '.' Matches any single character. '*' Matches zero or more of
 *              the preceding element.
 * 
 *              The matching should cover the entire input string (not partial).
 * 
 *              The function prototype should be: bool isMatch(const char *s,
 *              const char *p)
 * 
 *              Some examples: isMatch("aa","a") → false isMatch("aa","aa") →
 *              true isMatch("aaa","aa") → false isMatch("aa", "a*") → true
 *              isMatch("aa", ".*") → true isMatch("ab", ".*") → true
 *              isMatch("aab", "c*a*b") → true
 * @author Potato
 *
 */
public class T10 {

	public static void main(String[] args) {
		T10 t10 = new T10();
		System.out.println(t10.isMatch("abdesfeb", "a*.*bb*"));
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		print(dp);
		return dp[s.length()][p.length()];
	}
	public void print(boolean dp[][]){
		for(int i=0;i<dp.length;i++){
			for(int k=0;k<dp[i].length;k++){
				System.out.print((dp[i][k]?1:0)+" ");
			}
			System.out.println();
		}
	}
}
