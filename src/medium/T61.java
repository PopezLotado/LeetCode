package medium;

import java.util.ArrayList;
import java.util.List;

import util.ListNode;

/**
 * @Title Rotate List
 * @Description Given a list, rotate the list to the right by k places, where k
 *              is non-negative.
 * 
 *              For example: Given 1->2->3->4->5->NULL and k = 2, return
 *              4->5->1->2->3->NULL.
 * @author Potato
 *
 */
public class T61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {
		List<ListNode> save=new ArrayList<>();
		ListNode t=head;
		while(t!=null){
			save.add(t);
			t=t.next;
		}
		int n=save.size();
		if(n==0)
			return null;
		k=k%n;
		if(k==0)
			return head;
		save.get(n-1-k).next=null;
		save.get(n-1).next=head;
		head=save.get(n-k);
		return head;
	}

}
