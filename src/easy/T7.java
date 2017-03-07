package easy;

public class T7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T7 t7=new T7();
		System.out.println(t7.reverse(-2147483647));

	}
	
	 public int reverse(int x) {
		 int flag=1;
	      if(x<0)
	      {
	    	  if(x<=Integer.MIN_VALUE)
	    		  return 0;
	    	  x=-1*x;
	    	  flag=-1;
	      }
	      long res=0;
	      while(x!=0){
	    	  res=res*10+ x % 10;
	    	  x/=10;
	      }
	      if(res>Integer.MAX_VALUE)
	    	  return 0;
	      else
	          return flag*(int)res;
	 }

}
