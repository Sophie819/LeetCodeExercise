package name.sophy.easy;
/*
 * 2017.11.03
 * 下午好困，就练习几道题目吧。
 * 这道题目考察的是链表，用链表来反向存储一串数字，然后进行加法计算，结果仍然是一个链表
 */
public class EX_2 {
	
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListHead = new ListNode(0);
        ListNode node1 = l1;		//指针指向链表的第一位（数字的最后一位）
        ListNode node2 = l2;
        ListNode curResult = resultListHead;	//指针指向结果链表的头部
        int carry = 0;
        while(node1 != null || node2 != null){
        	int num1 = (node1 == null)?0:node1.val;
        	int num2 = (node2 == null)?0:node2.val;
        	int sum = carry + num1 + num2;
        	carry = sum / 10;//进位
        	curResult.next = new ListNode(sum % 10);
        	curResult = curResult.next;
        	if(node1 != null) node1 = node1.next;	//两个链表的指针移到下一位
        	if(node2 != null) node2 = node2.next;
        }
        //最后考虑最高位的进位
        if(carry > 0){
        	curResult.next = new ListNode(carry);
        }
        return resultListHead.next;
    }
}