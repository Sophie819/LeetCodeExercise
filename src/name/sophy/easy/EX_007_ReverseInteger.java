package name.sophy.easy;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午6:35:15 
* Introduction of the class:
*/
public class EX_007_ReverseInteger {
	public int reverse(int x) {
		int result = 0;
		while(x != 0) {
		   int tail = x % 10;
		   int newResult = result * 10 + tail;
		   if((newResult - tail) / 10 != result) { //If overflow exists, the new result will not equal previous one.
			   return 0;							//这种判断溢出的方法真的是通用的正确的吗？
		   }
		   result = newResult;
		   x = x/10;
		}
		return result;
    }
	
	public static void main(String[] args) {
		EX_007_ReverseInteger ex_7 = new EX_007_ReverseInteger();
		System.out.println(ex_7.reverse(1534236469));
	}
}
 