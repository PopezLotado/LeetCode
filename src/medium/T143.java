package medium;

import util.ListNode;

public class T143 {

	public static void main(String[] args) {

	}

	public void reorderList(ListNode head) {
        ListNode t=head;
        int c=0;
        while(t!=null){
        	t=t.next;
        	c++;
        }
        ListNode [] right=new ListNode[c/2];
        int m=c%2==0?c/2:c/2+1;
        c=0;
        t=head;
        while(c<m){
        	t=t.next;
        	c++;
        }
        for(int i=0;i<right.length;i++){
        	right[i]=t;
        	t=t.next;
        }
        
        t=head;
        ListNode s;
        for(int i=right.length-1;i>=0;i--){
        	s=t.next;
        	t.next=right[i];
        	right[i].next=s;
        	t=s;
        }
        if(t!=null)
        	t.next=null;
        }

}

