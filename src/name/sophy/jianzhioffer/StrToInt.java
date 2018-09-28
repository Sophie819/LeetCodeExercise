package name.sophy.jianzhioffer;
/*
 * 20180911:把字符串转化为整数
 * 思路：要考虑边界情况：1.存在字符；2.正负号；3.数字溢出（int范围-2^31 ~ 2^31-1）
 * 0111 1111 1111 1111 1111 1111 1111 1111
 * 1000 0000 0000 0000 0000 0000 0000 0000 (补码)
 */
public class StrToInt {
	public int StrToInt(String str) {
		//需要考虑到边界条件：str为空；数值溢出；是否有正负号
        if(str == null || str.trim().length() == 0)//invalid
            return 0;
        int symbol = 1;
        if(str.charAt(0) == '-') 
        		symbol = -1;
        int result = 0;
        for(int i = (str.charAt(0) ==  '-' || str.charAt(0) == '+') ? 1 : 0; i < str.length(); ++i){
            if (str.charAt(i) > '9' || str.charAt(i) < '0') 	//invalid
                 return 0;
            int sum = result * 10 + (int) (str.charAt(i) - '0');
            if( (sum - (int) (str.charAt(i) - '0')) / 10 != result)//溢出,invalid
                return 0;
            result = sum;
        }
        return symbol*result;
	}
}
