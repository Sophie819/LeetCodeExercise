package name.sophy.leetcode;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午7:44:15 
* Introduction of the class:
*/
public class EX_9 {
	public boolean isPalindrome(int x) {
        //判断x是不是负数或是XXXX0这样的数
		if(x < 0 || (x %10) == 0 && x != 0)
			return false;
		//翻转一半的数，判断是否是回文数
		int revertedX = 0; 
		while(revertedX < x){
			revertedX = revertedX * 10 + x % 10;
			x = x / 10;
		}
		
		return (x == revertedX) || (revertedX / 10 == x);
    }
}
 