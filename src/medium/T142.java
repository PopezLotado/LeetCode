package medium;

import java.util.HashSet;
import java.util.Set;

import util.ListNode;

/**
 * @Title Linked List Cycle II
 * @Description Given a linked list, return the node where the cycle begins. If
 *              there is no cycle, return null.
 * 
 *              Note: Do not modify the linked list.
 * 
 *              Follow up: Can you solve it without using extra space?
 * @author Potato
 *
 */
public class T142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode walker=head;
        ListNode runner=head;
        ListNode cycleinner=null;
        while(runner.next!=null && runner.next.next!=null){
        	walker=walker.next;
        	runner=runner.next.next;
        	if(walker==runner)
        	{
        		cycleinner=walker;
        		break;
        	}
        }
        if(cycleinner==null)
        	return null;
        walker = head;
        while( walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }
//        Set<ListNode> cycles=new HashSet<>();
//        while(!cycles.contains(cycleinner)){
//        	cycles.add(cycleinner);
//        	cycleinner=cycleinner.next;
//        }
//        walker=head;
//        while(!cycles.contains(walker)){
//        	walker=walker.next;
//        }
        return walker;
    }
	
	

}
