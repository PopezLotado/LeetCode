package medium;

/**
 * @Title Multiply Strings
 * @Description Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author Potato
 *
 */
public class T43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T43 t43=new T43();
		System.out.println(t43.multiply("0", "333"));
	}
	
	public String multiply(String num1, String num2) {
		if(num1.length()<num2.length()){
			String t=num1;
			num1=num2;
			num2=t;
		}
		int n1=num1.length();
		int n2=num2.length();
        int matrix[][]=new int[n2][n1+1];
        char res[]=new char[n1+n2];
        for(int i=0;i<n2;i++){
        	int b=0;
        	for(int j=n1;j>0;j--){
        		int t=(num1.charAt(j-1)-'0')*(num2.charAt(n2-1-i)-'0')+b;
        		if(t>=10){
        			b=t/10;
        			t=t%10;
        		}else
        			b=0;
        		matrix[i][j]=t;
        	}
        	matrix[i][0]=b;
        }
        int k=res.length-1;
        int b=0;
        for(int i=res.length-1;i>=0;i--){
        	int sum=b;
        	int basic=n1-k+i;
        	for(int j=0;j<n2;j++){
        		if(basic+j>=0 && basic+j<=n1)
        			sum+=matrix[j][basic+j];
        	}
        	if(sum>=10){
    			b=sum/10;
    			sum=sum%10;
    		}else
    			b=0;
        	res[i]=(char)(sum+'0');
        }
        int i=0;
        while(i<res.length && res[i]=='0')
        	i++;
        if(i>=res.length)
        	return "0";
        else
        	return new String(res,i,res.length-i);
    }
}
