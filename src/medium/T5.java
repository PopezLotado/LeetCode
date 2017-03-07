package medium;

public class T5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      T5 t5=new T5();
      System.out.println(t5.longestPalindrome("aaaabbbbbbccccccbbbbbbaaaa"));
	}
	 public String longestPalindrome(String s) {
		 String result=s.charAt(0)+"";
		 for(int i=0;i<s.length()-1;i++){
			 String s1=center(s, i, i);
			 String s2=center(s, i, i+1);
			 String ss=s1.length()>=s2.length()?s1:s2;
			 if(result.length()<ss.length())
				 result=ss;
		 }
		 return result;
	 }
	 public String center(String s,int i,int j){
		 while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
			 i--;
			 j++;
		 }
		 return s.substring(i+1, j);
	 } 
}
