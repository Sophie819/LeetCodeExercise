package name.sophy.leetcode;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月18日 下午9:36:33 
* Introduction of the class:	binary-tree-level-order-traversal-ii
*/

  public class EX_107 {
    
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//    	//树的遍历，BFS
//    	if(root == null)
//    		return new LinkedList<List<Integer>>();
//        Queue<TreeNode> q = new LinkedList<TreeNode>();//用队列存储，进行BFS
//        q.offer(root);
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        while(q.size() > 0){
//        	int tempCount = q.size();
//        	List<Integer> tempList = new LinkedList<Integer>();//某一层的元素
//            for(int i = 0; i < tempCount; i++){
//            	if(q.peek().left != null)	q.offer(q.peek().left);
//            	if(q.peek().right != null)	q.offer(q.peek().right);
//            	tempList.add(q.poll().val);
//            }
//            result.add(0, tempList);	//0表示加在list的头部
//        }
//        return result;
//    }
	  
	  //DFS（没有完全弄懂？？？）
	  public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
          levelMaker(wrapList, root, 0);
          return wrapList;
      }
      
      public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
          if(root == null) return;
          if(level >= list.size()) {
              list.add(0, new LinkedList<Integer>());
          }
          levelMaker(list, root.left, level+1);
          levelMaker(list, root.right, level+1);
          list.get(list.size()-level-1).add(root.val);
      }
}
 