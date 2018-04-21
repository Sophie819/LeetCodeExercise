package name.sophy.easy;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月19日 下午1:59:40 
* Introduction of the class:
* 	Balanced Binary Tree
* 	Given a binary tree, determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined as:
		a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

public class EX_110 {
	boolean isBalanced = true;
	public boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
	    //注意平衡二叉树是任意一个节点的左右子树的深度之差最多为1，思路是后序遍历并且计算子树的depth，先遍历左右子树，判断左右子树是否是平衡的，然后遍历跟
		getDepth(root);
		return isBalanced;
	}
	
	public int getDepth(TreeNode root){
		if(root == null)
			return 0;
		int depthOfLeft = getDepth(root.left);
		int depthOfRight = getDepth(root.right);
		if(Math.abs(depthOfLeft - depthOfRight) > 1)
			isBalanced = false;
		return (depthOfLeft > depthOfRight)?(depthOfLeft + 1):(depthOfRight + 1);
	}
}
 