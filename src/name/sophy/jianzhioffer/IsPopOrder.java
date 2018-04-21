package name.sophy.jianzhioffer;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午6:16:45 
* Introduction of the class:
*/
public class IsPopOrder {
	 public boolean isPopOrder(int [] pushA,int [] popA) {
		 if(pushA.length == 0 || popA.length == 0)
	            return false;
	        int popIndex = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        for(int i = 0; i < pushA.length; i++){
	            //按照push顺序将元素push到栈中，然后判断当前pop的元素是否在栈顶，如果在就pop出来
	            stack.push(pushA[i]);
	            while(!stack.empty() && stack.peek() == popA[popIndex]){
	                stack.pop();
	                popIndex++;
	            }
	        }
	        return stack.size() > 0?false:true;
	    }
	 
	 public static void main(String[] args) {
		 int [] pushA = {1,2,3,4,5};
		 int [] popA = {4,5,3,2,1};
		IsPopOrder isBalanced = new IsPopOrder();
		System.out.println(isBalanced.isPopOrder(pushA, popA));
	}
}
 