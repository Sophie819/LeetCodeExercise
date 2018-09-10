package name.sophy.leetcode;
import java.util.Stack;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月16日 下午8:51:30 
* Introduction of the class:
*/
public class EX_20 {
	 public boolean isValid(String s) {
		 Stack<Character> stack = new Stack<Character>();
		 for(int i = 0; i < s.length(); i++){
			 if(stack.size() != 0 && ifMatch(stack.peek(), s.charAt(i))){	//栈非空，与栈顶元素比较
				 stack.pop();
			 }
			 else
				 stack.push(s.charAt(i));
		 }
		 return (stack.size() == 0);
	 }
	 
	 public boolean ifMatch(char c1 , char c2){
		 if(c1 == '(' && c2== ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 =='}')
			 return true;
		 else
			 return false;
	 }
}
 