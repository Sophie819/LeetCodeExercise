package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午5:51:10 
* Introduction of the class:
*/
public class IsBalanced {
	public boolean IsBalanced_Solution(TreeNode root){
		//后序遍历，先遍历左右子树，记录深度，然后判断当前根节点的树是否平衡
		//看下来最好的答案,里面剪枝了。很多其他算法都没剪枝,一直把节点全部遍历了一遍
		return getDepth(root) != -1;
	}
	
	private int getDepth(TreeNode root){
		if (root == null) 
			return 0;
		
		int left = getDepth(root.left);
		if (left == -1) 
			return -1;
		
		int right = getDepth(root.right);
		if (right == -1) 
			return -1;

		return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);

	}
	
}
 