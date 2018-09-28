package name.sophy.jianzhioffer;
import name.sophy.common.*;
/*
 * 20180911:删除链表中重复的节点(链表已经排好序)
 * 思路：递归,返回处理好的头节点
 */
public class DeleteDuplication {
	 public ListNode deleteDuplication(ListNode pHead) {
		 if(pHead == null)
			 return null;
		 if(pHead.next == null)
			 return pHead;
		 if(pHead.val == pHead.next.val) {	//当前节点和下一个节点重复，与该节点相同的值全部删去1223334->14
			 ListNode temp = pHead;
			 while(temp != null && temp.val == pHead.val)
				 temp = temp.next;
			 return deleteDuplication(temp);
		 }
		 else{
			 pHead.next = deleteDuplication(pHead.next);
			 return pHead;
		 }
	 }   
}
