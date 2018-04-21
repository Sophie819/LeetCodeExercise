package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 上午10:36:42 
* Introduction of the class: 从1到n整数中1出现的次数（需要耐心找到规律，还要细心考虑每种情况的边界）
* 		还是要自己先思考，然后实在想不出来了，再看书上的解法！！！不然光背答案有啥用呢！！！看过一遍，过一段时间再自己写出来！！！不要直接抄！！！
*/
public class NumberOf1Between1AndN {
	public int NumberOf1Between1AndN_Solution(int n) {
		//考虑n = 0或者1的情况
		return NumberOfOne(n);
	}
	
	public int NumberOfOne(int n){
		//考虑只有一位数字的时候，注意这个是递归的出口！！！
		if(n == 0)
			return 0;
		if(n >= 1 && n < 10)
			return 1;
		
		//递归，考虑每一位出现1的次数
		String string = String.valueOf(n);
		int numberOfFirst = string.charAt(0) - '0';
		System.out.println("first : " + numberOfFirst);
		
		//21345 ： 1 ~ 1235 and 1346 ~ 21345
		//下面先计算关于这部分的，1346 ~ 21345
		//计算最高位（第一位）出现1的次数 
		int numberFirstDigit = 0;	
		if(numberOfFirst > 1){		//10000 ~ 19999
			numberFirstDigit = (int)Math.pow(10, string.length() - 1);
		}
		else if(numberOfFirst == 1){		//10000~12344
			numberFirstDigit = Integer.parseInt(string.substring(1)) + 1;
		}
		
		//计算其他几位1出现的次数（除了第一位）
		int numberOtherDigits = 0;
		numberOtherDigits = numberOfFirst * (string.length() - 1) * (int)Math.pow(10, string.length() - 2);
		
		//递归考虑1 ~ 1235
		int numberRecursive = NumberOfOne(Integer.parseInt(string.substring(1)));
		System.out.println(numberFirstDigit + ", " + numberOtherDigits + ", " + numberRecursive);
		
		return numberFirstDigit + numberOtherDigits + numberRecursive;
	}
	
	public static void main(String[] args) {
		NumberOf1Between1AndN m = new NumberOf1Between1AndN();
		m.NumberOf1Between1AndN_Solution(10);
	}
}
 