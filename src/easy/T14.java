package easy;
/**
 * @Title Longest Common Prefix
 * @Description 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author Potato
 *
 */
public class T14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T14 t14=new T14();
		String []strs={"abcdE","abcdff","abcwww"};
		System.out.println(t14.longestCommonPrefix(strs));
	}
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String res=getCommon(strs[0], strs[1]);
        for(int i=2;i<strs.length;i++)
        	res=getCommon(res, strs[i]);
        return res;
    }
    public String getCommon(String s1,String s2){
    	int end=s1.length()<s2.length()?s1.length():s2.length();
    	int i=0;
    	for(;i<end;i++){
    		if(s1.charAt(i)!=s2.charAt(i))
    			break;
    	}
    	return s1.substring(0, i);
    }

}
