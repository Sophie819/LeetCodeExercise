package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月16日 下午1:14:31 
* Introduction of the class:
*/
public class EX_019_RemoveNthNodeFromEndofList {
	//快慢指针的思想，指针间隔为n+1，我们要用慢指针指向要删除的那个节点之前的一个节点，而且要删除的很可能是head，所以我们要用一个新节点指向head，然后进行遍历处理
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        ListNode p1 = temp;
        ListNode p2 = temp;
        temp.next = head;
        for(int i = 1; i <= (n+1); i++)
            p1 = p1.next;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return temp.next;
    }
}
 