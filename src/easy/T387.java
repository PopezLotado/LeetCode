package easy;

/**
 * @Title First Unique Character in a String
 * @Description Given a string, find the first non-repeating character in it and
 *              return it's index. If it doesn't exist, return -1.
 * 
 *              Examples:
 * 
 *              s = "leetcode" return 0.
 * 
 *              s = "loveleetcode", return 2. Note: You may assume the string
 *              contain only lowercase letters.
 * @author Potato
 *
 */
public class T387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqChar2(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
	public int firstUniqChar(String s) {
		String origin=s;
		String rest=s;
		while(rest.length()!=0 && s.length()-rest.length()!=1){
			s=rest;
			rest=remove(s);
		}
		if(s.length()-rest.length()==1){
			char c=s.charAt(0);
			int r=0;
			while(origin.charAt(r)!=c)
				r++;
			return r;
		}else
			return -1;
		
	}
	
	public String remove(String s){
		StringBuilder sb=new StringBuilder("");
		char c=s.charAt(0);
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)!=c)
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
