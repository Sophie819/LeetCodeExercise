package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月3日 下午4:53:04 
* Introduction of the class:
* 		输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
import java.util.*;
public class FindPath {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	//记录所有符合的路径
    ArrayList<Integer> arr = new ArrayList<Integer>();//记录当前从根节点进行前序遍历的路径
    int num = 0;									  //记录当前从根节点进行前序遍历的路径长度
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null)
        	return result;
        boolean isLeaf = (root.left == null) && (root.right == null);
        
        num += root.val;	//计算当前路径长度
        arr.add(root.val);
        if(num == target && isLeaf){	//已经遍历到叶子节点，并且该路径是符合要求的
        	//注意这里不能直接result.add(arr)，因为arr是记录当前路径的，随时都是改变的，需要进行深拷贝
        	ArrayList<Integer> path = new ArrayList<Integer>();
            for(int i=0;i<arr.size();i++)
                path.add(arr.get(i));
            result.add(path);
        }
        if(num < target && root.left != null){	//左节点不为空，遍历左节点
        	findPath(root.left, target);
        }
        if(num < target && root.right != null){	//右节点不为空，遍历右节点
        	findPath(root.right, target);
        }
        num -= root.val;	//root节点的左右子树都遍历完了，现在可以回溯到root的上一个节点了
        arr.remove(arr.size() - 1);
        return result;
    }
}
 