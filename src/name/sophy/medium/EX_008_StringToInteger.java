package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月10日 下午12:12:24 
* Introduction of the class: 这题目做的脑阔痛，题目描述不清不楚
*/
public class EX_008_StringToInteger {
	 public static int myAtoi(String str) {
        //discards all leading whitespaces
        //sign of the number
        //overflow
        //invalid input
        if(str == null || str.length() == 0)
            return 0;
        int i = 0;
        int positive = 1;
        int sum = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')){
            positive = (str.charAt(i) == '+') ? +1 : -1;
            i++;
        }
        System.out.println(positive);
        for(; i < str.length(); i++){
            int tempDigit = (str.charAt(i) - '0');
            if(tempDigit < 0 || tempDigit > 9)
                break;
            //注意：这里需要判断是否溢，之前判断(newSum - digit) / 10 != sum，是有问题的！！！
            if(Integer.MAX_VALUE / 10 < sum || ( Integer.MAX_VALUE / 10 == sum && tempDigit > Integer.MAX_VALUE % 10))
            	return (positive == 1)?Integer.MAX_VALUE : Integer.MIN_VALUE;
            sum = sum * 10 + tempDigit;
        }
	    return positive * sum; 
	 }
	 
	 public static void main(String[] args) {
		myAtoi("2147483648");
	}
}
 