package easy;

/**
 * @Title First Bad Version
 * @Description You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * @author Potato
 *
 */
public class T278 {

	boolean ba[]={true,false,false,false,false,false,false};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2126753390 versions
		//1702766719 is the first bad version.
		T278 t278=new T278();
		System.out.println(t278.firstBadVersion(Integer.MAX_VALUE));
	}
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
        int l=1;
        int h=n;
        while(l<=h){
        	int mid=l+(h-l)/2;
        	System.out.println(mid);
        	if(isBadVersion(mid)) 
        		h=mid-1;
        	else
        		l=mid+1;
        }
        return l;
    }
	boolean isBadVersion(int version){
		return version>=Integer.MAX_VALUE;
	}
}
