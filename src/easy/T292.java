package easy;

/**
 * @Title Nim Game
 * @Description You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 * @author Potato
 *
 */
public class T292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T292 t292=new T292();
		System.out.println(t292.canWinNim(9999));
	}
	
	byte save[];
    public boolean canWinNim(int n) {
    	// return n%4!=0;    一句即可
        if(n==1 || n==2 || n==3) return true;
		save=new byte[n+1];
		save[1]=1;
		save[2]=1;
		save[3]=1;
		for(int i=4;i<=n;i++)
			save[i]=-1;
		return best(n);
    }
	public boolean best(int n){
		if(save[n]!=-1)
			return save[n]==1?true:false;
		if(best(n-1) && best(n-2) && best(n-3)){
			save[n]=0;
			return false;
		}
		else{
			save[n]=1;
			return true;
		}
	}

}
