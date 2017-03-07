package medium;

public class T343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T343 t343=new T343();
		System.out.println(t343.integerBreak(58));
	}

    public int integerBreak(int n) {
    	int r=1;
    	int rt[]={1,2,4};
    	if(n<5) return rt[n-2];
    	while(n>=5){
    		r*=3;
    		n-=3;
    	}
    	r*=n;
    	return r;
    	
    }
}
