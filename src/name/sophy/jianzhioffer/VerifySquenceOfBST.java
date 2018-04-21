package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月3日 下午3:54:07 
* Introduction of the class:
* 		输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
public class VerifySquenceOfBST {
	public boolean verifySquenceOfBST(int [] sequence) {
		return verify(sequence, 0, sequence.length - 1);
    }
	
	 //后序遍历，先遍历左右子节点，再遍历根节点
    //注意二叉搜索树的特征是 左子树<root<右子树，所以依据这个特征来判断是否是后序遍历的序列
	public boolean verify(int [] sequence, int begin, int end){
		if(begin > end)
			return false;
        if(begin == end)
            return true;
		int root = sequence[end];	//后序遍历，最后一位是root
		int i = begin;
		for(; i <= end - 1; i++){//找到左子树序列，注意这里的i其实指向右子树第一个节点
			if(sequence[i] > root)
				break;
		}
		int j = i;
		for(; j <= end - 1; j++){
			if(sequence[j]  < root)	//找到右子树序列，判断是否都大于root
				return false;
		}
		boolean left = true, right = true;
		if(i > begin)	//有左子树，需要递归判断左子树是否是二叉搜索树！！！
			left =  verify(sequence, begin, i - 1);
		if(i < end)	//有右子树，需要递归判断右子树是否是二叉搜索树！！！
			right = verify(sequence, i, end - 1);
		return (left && right);
	}
}
 