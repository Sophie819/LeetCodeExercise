package name.sophy.easy;
import java.util.HashMap;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午8:14:32 
* Introduction of the class: 罗马数字转换为int型
* 首先是进制： 
	Roman numerals ( 罗马数字 ) : 
	I = 1 
	V = 5 
	X =10 
	L = 50 
	C = 100 
	D = 500 
	M = 1000 
	规律： 
	III = 1+1+1=3 
	IV = 5-1=4 
	VI = 5+1=6 
	IX = 10-1=9 
	XI = 10+1=11 
	XXI = 10+10+1=21 
	LXX=50+10+10=70 
	LXXX=80 
	XC=100-10=90 
	1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
	2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
	3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
	4、正常使用时，连写的数字重复不得超过三次。
*/
public class EX_013_RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
	        return 0;
	    int len = s.length();
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    int result = map.get(s.charAt(len - 1));
	    int pivot = result;
	    for (int i = len - 2; i >= 0; i--) {
	        int curr = map.get(s.charAt(i));
	        if (curr >= pivot) {
	            result += curr;
	        } else {
	            result -= curr;
	        }
	        pivot = curr;
	    }
	    return result;
    }
}
 