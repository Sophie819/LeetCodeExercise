package name.sophy.jianzhioffer;
import name.sophy.common.*;
/*
 * 20180910：二刷
 */
public class Mirror {
	//递归
	public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
