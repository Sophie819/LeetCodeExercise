package name.sophy.jianzhioffer;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午12:26:25 
* Introduction of the class:
* 	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
* 	
*/
public class PrintMinNumber {
	public String printMinNumber(int [] numbers) {
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++){
			array.add(String.valueOf(numbers[i]));
		}
		Collections.sort(array, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String str1 = o1 + o2;
				String str2 = o2 + o1;
				return str1.compareTo(str2);	//str1 < str2 时，o1应该排在o2前面（顺序不变）； str1 > str2， o2排在o1前面（）
			}
			
		});
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < array.size(); i++)
			result.append(array.get(i));
		return result.toString();
    }
}
 