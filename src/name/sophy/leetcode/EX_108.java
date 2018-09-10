package name.sophy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月19日 上午11:27:36 
* Introduction of the class:	
* 	convert-sorted-array-to-binary-search-tree
* 	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
* 	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
public class EX_108 {
	//考察分治和递归
	//一开始理解错了题意，以为是只要报数组转化为树就行了，还要考虑平衡树，就是左右两个子树的深度之差最大为1
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
        	return null;
        return subSortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode subSortedArrayToBST(int [] nums, int startIndex, int endIndex){
    	//这个函数设置了左右节点，返回根节点
    	if(startIndex > endIndex)
    		return null;
    	if(startIndex == endIndex)
    		return new TreeNode(nums[startIndex]);
    	int mid = (startIndex + endIndex) / 2;	//为了构造一个平衡树，所以取中间的元素作为跟，左半边作为左子树，右半边作为右子树
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = subSortedArrayToBST(nums, startIndex, mid - 1);
    	root.right = subSortedArrayToBST(nums, mid + 1, endIndex);
    	return root;
    }
}
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */