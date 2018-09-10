package name.sophy.leetcode;

import java.util.Stack;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月22日 下午3:56:42 
* Introduction of the class: 根据二叉树的前序遍历和中序遍历，重构这个二叉树
*/
public class EX_73 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int preStart = 0;
    	if(pre.length == 0 || in.length == 0)
        	return null;
        return buildTree(pre, in, 0, 0, in.length - 1);
    }
    
    public TreeNode buildTree(int [] pre , int [] in, int preStart, int inStart, int inEnd){
    	 if(preStart > inEnd || preStart> pre.length){  
             return null;  
         }  
    	TreeNode root = new TreeNode(pre[preStart]);
        int subNum = 0;//	在中序遍历中找到root的位置
        for(int i = 0; i < in.length;i ++){
        	if(in[i] == root.val)
        		subNum = i;
        }
        root.left = buildTree(pre, in, preStart + 1, inStart, subNum - 1);
        root.right = buildTree(pre, in, preStart + 1 + subNum - inStart, subNum + 1, inEnd);
        return root;
    }
    
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n - 1) & n;
            System.out.println(n);
        }
        return count;
    }
    
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < pushA.length; i++){
            //按照push顺序将元素push到栈中，然后判断当前pop的元素是否在栈顶，如果在就pop出来
            stack.push(pushA[i]);
            if(!stack.empty() && stack.peek() == popA[popIndex]){
            	System.out.println(stack.peek());
                stack.pop();
                popIndex++;
            }
        }
        if(stack.empty())
        	System.out.println("true");
        return (stack.empty()?true:false);
    }  
    
    public static void main(String[] args) {
		int [] pre = {1,2,3,4,5,6,7};
		int [] in = {3,2,4,1,6,5,7};
		EX_73 ex_73 = new EX_73();
//		ex_73.reConstructBinaryTree(pre, in);
//		ex_73.NumberOf1(-2147483647);
		
		int [] a = {1,2,3,4,5};
		int [] b = {1,2,3,4,5};
		ex_73.IsPopOrder(a, b);
	}
}


// //Definition for binary tree
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
 
 