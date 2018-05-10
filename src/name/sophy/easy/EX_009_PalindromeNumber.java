package name.sophy.easy;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午7:44:15 
* Introduction of the class: 翻转一般的数字即可
*/
public class EX_009_PalindromeNumber {
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
 