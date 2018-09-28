package name.sophy.jianzhioffer;
import name.sophy.common.*;
import java.util.Stack;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月3日 下午9:40:11 
* Introduction of the class:
*/
public class BiTreeConvertToBiList {
	public TreeNode Convert(TreeNode pRootOfTree) {
		 if(pRootOfTree == null)  
             return null;  
         Stack<TreeNode> stack = new Stack<TreeNode>();  
         TreeNode p = pRootOfTree;//让p指向根节点
         while(p.left != null){
        	 p = p.left;
         }
         TreeNode head = p;
         p = pRootOfTree;
         TreeNode last = null;	//记录上一个被pop出来的节点
         while(!stack .empty() || p != null  )  
         {  
             while(p != null)   	//一直遍历到左子树最下边，边遍历边保存根节点到栈中(每个节点都可以看成一个新的子树的根节点) 
             {  
                 stack.push(p);		//若节点的左孩子不为空，将左孩子压栈，因为需要借助遍历过的节点进入右子树  
                 p = p.left;  
             }  
             if(stack != null)  	 //当p为空时，说明已经到达左子树最下边，这时需要出栈了  
             {  
                 p = stack.pop();  
                 System.out.print(p.val + "-->");//访问根节点  
                 if(last == null){
                	 last = p;
                	 
                 }
                 else{
                	 last.right = p;
                	 p.left = last;
                     last= p;
                 }
                 p = p.right;		//进入右子树，此时p是右子树的根节点（开始新一轮的遍历）  
             }
             
         }
         return head;
    }
}
 