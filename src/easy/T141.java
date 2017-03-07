package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title Linked List Cycle
 * @Description Given a linked list, determine if it has a cycle in it.
 * 
 *              Follow up: Can you solve it without using extra space?
 * @author Potato
 *
 */
public class T141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set=new HashSet<>();
//        ListNode t=head;
//        while(t!=null){
//        	if(set.contains(t))
//        		return true;
//        	set.add(t);
//        	t=t.next;
//        }
//        return false;
        
    	//Floyd's cycle-finding algorithm
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }

}
