package name.sophy.leetcode;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月16日 下午9:13:53 
* Introduction of the class:
*/
public class EX_21 {
	  public ListNode_21 mergeTwoLists(ListNode_21 l1, ListNode_21 l2) {
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        if(l1.val < l2.val){
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        }
	        else{
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        } 
	    }
	   
	  public static void main(String[] args) {
		 ListNode_21 node_11 = new ListNode_21(1);
		 ListNode_21 node_12 = new ListNode_21(2);
		 ListNode_21 node_13 = new ListNode_21(4);
		 ListNode_21 node_21 = new ListNode_21(1);
		 ListNode_21 node_22 = new ListNode_21(3);
		 ListNode_21 node_23 = new ListNode_21(4);
		 node_11.next = node_12;
		 node_12.next = node_13;
		 node_21.next = node_22;
		 node_22.next = node_23;
		 EX_21 ex_21 = new EX_21();
		 ListNode_21 node = ex_21.mergeTwoLists(node_11, node_21);	
		 while(node != null){
			 System.out.println(node.val);
			 node = node.next;
		 }
	  }
}

class ListNode_21 {
    int val;
    ListNode_21 next;
    ListNode_21(int x) { val = x; }
}