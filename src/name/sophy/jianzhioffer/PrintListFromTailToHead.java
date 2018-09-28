package name.sophy.jianzhioffer;
import java.util.ArrayList;

import name.sophy.common.*;
/*
 *	20180911:从尾到头打印链表
 *	思路：递归，先打印头节点之后的，最后打印头节点，或者用一个额外的栈存储所有节点，先进后出。
 */
public class PrintListFromTailToHead {
	ArrayList<Integer> result = new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
        		printListFromTailToHead(listNode.next);
        		result.add(listNode.val);
        }
        return result;
    }
}
