package name.sophy.easy;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午8:30:43 
* Introduction of the class: int型转化为罗马数字
*/
public class EX_12 {
	public String intToRoman(int num) {
		String[][] list={
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},//1~9
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},//10~90
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},//100~900
                {"","M","MM","MMM","","","","","",""}	//1000~3000
				};
		String str = "";
		return str + list[3][num / 1000] + list[2][num % 1000 / 100] + 
				list[1][num % 100 / 10] + list[0][num % 10];
    }
}
 