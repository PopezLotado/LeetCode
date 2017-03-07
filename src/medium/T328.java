package medium;

/**
 * @Title Odd Even Linked List
 * @Description Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 *
 */
public class T328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode2 oddEvenList(ListNode2 head) {
        if(head==null) return null;
        ListNode2 odd=head;
        if(head.next==null) return odd;
        ListNode2 even=head.next;
        ListNode2 t=even;
        ListNode2 oddTail=odd;
        ListNode2 evenTail=even;
        boolean isOdd=true;
        while(t.next!=null){
        	t=t.next;
        	if(isOdd){
        		oddTail.next=t;
        		oddTail=t;
        		isOdd=false;
        	}else {
				evenTail.next=t;
				evenTail=t;
				isOdd=true;
			}
        }
        oddTail.next=even;
        evenTail.next=null;
		return odd;
    }
}
class ListNode2 {
int val;
ListNode2 next;
ListNode2(int x) { val = x; }
}


