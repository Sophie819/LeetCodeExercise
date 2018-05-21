package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月16日 下午4:45:09 
* Introduction of the class:
*/
public class EX_029_DivideTwoIntegers {
	 public static int divide(int dividend, int divisor) {
	        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)//[−2^31,  2^31 − 1]，只有这种情况下会溢出
	        	return Integer.MAX_VALUE;
		 	int sign = ((dividend < 0) ^ (divisor < 0)) ? -1: 1;//nor
	        long dividendLong = Math.abs((long)dividend);
	        long divisorLong  = Math.abs((long)divisor);
	        long result = 0;
	        while(dividendLong >= divisorLong){ 
	            dividendLong -= divisorLong;
	            result++;
	        }
	        return (int) (sign * result);
	    }
	 
	 public static void main(String[] args) {
		System.out.println(divide(-2147483648, 1));
	}
}
 