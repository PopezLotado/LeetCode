package easy;

public class T70 {
	public static void main(String[] args) {
		T70 t70=new T70();
		System.out.println(t70.climbStairs(44));

	}

	public int climbStairs(int n) {
		int [] save=new int[n+1];
		save[1]=1;
		if(n>1)
			save[2]=2;
		for(int i=3;i<save.length;i++)
			save[i]=0;
		
	   return climb(save, n);
        
    }
	private int climb(int [] save,int n){
		if(save[n]!=0)
			return save[n];
        else {
        	save[n-1]=climb(save,n-1);
        	save[n-2]=climb(save,n-2);
        	return save[n-1]+save[n-2];
        }
	}
}
