package name.sophy.test;

import java.lang.reflect.Array;
import java.util.*;
//本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class XiaoHongShuEX_1 {
	
	 public static void main(String[] args) {
		 XiaoHongShuEX_1 function = new XiaoHongShuEX_1();
	     Scanner sc = new Scanner(System.in);
	     String levelStr = sc.nextLine();
	     String inStr = sc.nextLine();
	     String [] temp_1 = levelStr.split("\\s+");
	     int count = temp_1.length;
	     int [] levelOrder = new int[count];
	     for(int i = 0; i < temp_1.length; i++)
	    	 	levelOrder[i] = Integer.parseInt(temp_1[i]);
	     int [] inOrder = new int [count];
	     String [] temp_2 = inStr.split("\\s+");
	     for(int i = 0; i < temp_2.length; i++)
	    	 	inOrder[i] = Integer.parseInt(temp_2[i]);
	     
	     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	     for(int i = 0; i< count; i++)
	    	 	map.put(inOrder[i], i);
	     TreeNode root = new TreeNode(levelOrder[0]);//构造根节点
	     TreeNode [] helpper = new TreeNode [count];
	     helpper[map.get(levelOrder[0])] = root;
	     for(int i = 1; i < count; i++) {
	    	 	int tempNode = levelOrder[i];
	    	 	int index = map.get(tempNode);
	    	 	helpper[index] = new TreeNode(tempNode);	//找到level[i]在inorder中的index
	    	 	if(!function.getLeftParent(helpper, index))
	    	 		function.getRightParent(helpper, index);
	    	 }
	     
	     ArrayList<Integer> leaf = new ArrayList<Integer>();	   
	     for(int i = 0; i < count; i++) {
	    	 	if(helpper[i].left == null && helpper[i].right == null)
	    	 		leaf.add(helpper[i].val);
	     }
	     for(int i = 0; i < leaf.size(); i++)
	    	 	System.out.print(leaf.get(i) + " ");
	     System.out.println();
	     function.prOrderTree(root);
	     System.out.println();
	     function.postOrderTree(root);
	     System.out.println();
	 }
	 
	 // 前序遍历打印二叉树
	    public void prOrderTree(TreeNode node) {
	        if (node == null) {
	            return;
	        }
	        System.out.print(node.val + " ");
	        // 左子树
	        TreeNode left = node.left;
	        // 打印节点信息
	        if (left != null) {
	            prOrderTree(left);
	        }
	        // 右子树
	        TreeNode right = node.right;
	        if (right != null) {
	            prOrderTree(right);
	        }

	    }
	    
	 // 后序遍历
	    public void postOrderTree(TreeNode node) {
	        if (node == null) {
	            return;
	        }
	        // 左子树
	        TreeNode left = node.left;
	        if (left != null) {
	            postOrderTree(left);
	        }
	        // 右子树
	        TreeNode right = node.right;
	        if (right != null) {
	            postOrderTree(right);
	        }
	        // 打印节点信息
	        System.out.print(node.val + " ");

	    }
 
	 public boolean getLeftParent(TreeNode [] helpper, int index) {	//向左边，找到第一个作为该节点的左父亲（如果该父亲节点没有右孩子）
		 for(int i = index - 1; i >= 0; i--) {
			 if(helpper[i] != null) {
				 if(helpper[i].right == null)
				 {
					 helpper[i].right = helpper[index];
					 //System.out.println("设置" + helpper[i].val + "的右节点是" + helpper[index].val);
					 return true;
				 }
				 else
					 return false;
			 }
		 }
		 return false;
	 }
	 
	 public boolean getRightParent(TreeNode [] helpper, int index) {	//向右找到第一个节点作为该节点的右父亲（如果该父亲节点没有左孩子）
		 for(int i = index + 1; i < helpper.length; i++) {
			 if(helpper[i] != null) {
				 if(helpper[i].left == null)
				 {
					 helpper[i].left = helpper[index];
					 //System.out.println("设置" + helpper[i].val + "的左节点是" + helpper[index].val);
					 return true;
				 }
				 else
					 return false;
			 }
		 }
		 return false;
	 }
}

class TreeNode {
	public int val;
	 public TreeNode left;
	 public TreeNode right;
	 TreeNode(int x) { val = x; }
}
/*
 * Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		char temp = string.charAt(0);
		int count = 1;
		String result = "";
		//System.out.println(temp);
		for(int i = 1; i < string.length(); i++)	{
			if(temp == string.charAt(i)){
				count++;
				//System.out.println(count);
			}
			else {
				//System.out.println(count);
				if(count > 1)
					result += String.valueOf(count - 1);
				result +=  String.valueOf(temp);
				temp = string.charAt(i);
				count = 1;
			}
		}	
		if(count > 1)
			result += String.valueOf(count - 1);
		result += String.valueOf(temp);
		System.out.println(result);
 */
