package name.sophy.hard; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月10日 下午4:44:51 
* Introduction of the class:
*/
public class EX_065_ValidNumber {
	public static boolean isNumber(String s) {
        //需要考虑小数点，e,+-等特殊情况
		//判断每个字符
		//1.e后面只能接数字，不能有小数点，并且只能存在一个e
		//2.+-号只能出现在第一位或者e后面的第一位
		//3.小数点只能出现一次，不能出现在e后面
		boolean hasPoint = false;	//.
		boolean hasE = false;		//e
		//boolean hasSign = false;	//+-
		boolean numberSeen = false;
		boolean numberAfterE = true;//初始化为true的原因是，肯能不存在e，那就不需要判断这一标志了
		s = s.trim().toLowerCase();
		for(int i = 0; i < s.length(); i++){
			char temp = s.charAt(i);
			if(temp == 'e'){
				if(!numberSeen || hasE)
					return false;
				hasE = true;
				numberAfterE = false;	//出现e，就把改标志设置为false，后面如果出现数字会变成true，不然还是false
			}
			else if(temp == '.'){
				if(hasE || hasPoint)
					return false;
				hasPoint = true;
			}
			else if(temp == '+' || temp == '-'){
				if(i > 0 && s.charAt(i - 1) != 'e')
					return false;
				//hasSign = true;
			}
			else if(temp >= '0' && temp <= '9'){
				numberSeen = true;
				numberAfterE = true;	//可能此时是出现在e之后的数字
			}
			else {
				return false;
			}
		}
		return numberSeen & numberAfterE;
    }
	
	public static void main(String[] args) {
		if(isNumber(""))
			System.out.println("true");
	}
}
 