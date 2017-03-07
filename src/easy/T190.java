package easy;


/**
 * @Title Reverse Bits
 * @Description Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 * @author Potato
 *
 */
public class T190 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T190 t190=new T190();
		System.out.println(t190.reverseBits(-1));
	}
	
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
    	String b=Long.toBinaryString(Integer.toUnsignedLong(n));
    	while(b.length()<32)
    		b="0"+b;
        char [] s=b.toCharArray();
        for(int i=0,j=s.length-1;i<j;i++,j--){
        	char t=s[i];
        	s[i]=s[j];
        	s[j]=t;
        }
        return Integer.parseUnsignedInt(new String(s), 2);
    }

}
