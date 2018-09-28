package name.sophy.jianzhioffer;
import name.sophy.common.*;
/*
 * 20180911：链表中环的入口节点
 */
public class EntryNodeOfLoop {
	//主要用到两个指针，快慢指针相遇时，慢指针正好走了若干个环的长度，然后让快指针指向头部，最终相遇点即为所求
    public ListNode EntryNodeOfLoop(ListNode pHead) {
    		if(pHead == null || pHead.next == null)
    			return null;
    		ListNode fast = pHead, slow = pHead;
    		while(fast.next != null && fast.next.next!= null){
    			fast = fast.next.next;
    			slow = slow.next;
    			if(fast == slow) {
    				//两指针相遇
    				fast = pHead;
	    	    		while(fast != slow) {
	    	    			fast = fast.next;
	    	    			slow = slow.next;
	    	    		}
	    	    		return fast;
    			}
    		}
    		return null;
    }
}
