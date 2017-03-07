package easy;


/**
 * @Title Remove Linked List Elements
 * @Description Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Potato
 *
 */
public class T203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeElements(ListNode head, int val) {
        ListNode t=head;
        ListNode h=t;
        while(t!=null && t.val==val){
    		t=t.next;
    	}
        h=t;
        head=h;
        while(t!=null){
        	while(t!=null && t.val!=val){
        		h=t;
        		t=t.next;
        	}
        	while(t!=null && t.val==val){
        		t=t.next;
        	}
        	h.next=t;
        	h=t;
        	if(t!=null)
        		t=t.next;
        }
        return head;
    }

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
