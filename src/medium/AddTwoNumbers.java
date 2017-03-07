package medium;

import util.ListNode;

public class AddTwoNumbers {
       
       public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	   boolean yn=false;
    	   ListNode h=new ListNode(0);
    	   ListNode t=h;
    	   
    	   while(l1!=null && l2!=null){
    		   int s=l1.val+l2.val;
    		   s+=yn?1:0;
        	   yn=s>9?true:false;
        	   int r=yn?s-10:s;
        	   ListNode l=new ListNode(r);
        	   t.next=l;
        	   t=l;
        	   l1=l1.next;
        	   l2=l2.next;
    	   }
    	   if(l1==null){
    		   while(l2!=null){
    			   int s=l2.val;
        		   s+=yn?1:0;
            	   yn=s>9?true:false;
            	   int r=yn?s-10:s;
            	   ListNode l=new ListNode(r);
            	   t.next=l;
            	   t=l;
            	   l2=l2.next;
    		   }
    	   }else {
    		   while(l1!=null){
    			   int s=l1.val;
        		   s+=yn?1:0;
            	   yn=s>9?true:false;
            	   int r=yn?s-10:s;
            	   ListNode l=new ListNode(r);
            	   t.next=l;
            	   t=l;
            	   l1=l1.next;
    		   }
		}
    	   if(yn){
    		   ListNode l=new ListNode(1);
        	   t.next=l;
        	   t=l;
    	   }
    		   t.next=null;
           return h.next;
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
