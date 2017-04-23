package easy;

public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        T6 t6=new T6();
        System.out.println(t6.convert("PAYPALISHIRING", 3));
	}

	 public String convert(String s, int numRows) {
		 if(s.isEmpty())
			 return s;
		    int b=2*numRows-2;
		    int size;
		    if(b==0) b=1;
	        size=s.length()/b;
	        if(s.length()%b!=0)
	        	size++;
	        String [] ss=new String[size];
	        int i=0;
	        for(;i<size-1;i++){
	        	ss[i]=s.substring(i*b, i*b+b);
	        }
	        ss[size-1]=s.substring(i*b);
	        
	        String result="";
            for(int k=0;k<numRows;k++){
            	for(int j=0;j<size;j++){
            		if(k==0){
            			if(k<ss[j].length())
            			   result+=ss[j].charAt(k);
            		}else if(k==numRows-1){
            			if(k<ss[j].length())
            			   result+=ss[j].charAt(k);
            		}else {
            			if(k<ss[j].length())
            				result+=ss[j].charAt(k);
            			if((b-k)<ss[j].length())
            				result+=ss[j].charAt(b-k);
					}
            	}
            }	        
	        return result;
	 }
}
