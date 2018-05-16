package name.sophy.medium;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月15日 下午5:13:22 
* Introduction of the class:
*/
public class EX_017_LetterCombinationsofaPhoneNumber {
	static String  [] charmap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static List<String> letterCombinations(String digits) {
		/*
        LinkedList<String> result = new LinkedList<String>();
        if(digits == null || digits.length() == 0)
            return result;
        result.offerLast("");
        for(int i = 0; i < digits.length(); i++){
            String tempCharArray = charmap[digits.charAt(i) - '0'];  //要加入的字符数组
            int tempPreCount = result.size();                        //相当于BFS,上一层的字符串个数
            for(int j = 0; j < tempPreCount; j++){
                String tempStr = result.peekFirst();
                for(int k = 0; k < tempCharArray.length(); k++)
                    result.offerLast(tempStr + tempCharArray.charAt(k));
                result.pollFirst();
            }
        }
        return result;*/
		
		//递归版本
		LinkedList<String> result = new LinkedList<String>();
        if(digits == null || digits.length() == 0)
            return result;
        combination("", digits, 0, result);
        return result;
    }
	
	public static void combination(String prefix, String digits, int offset, LinkedList<String> result){
		if(offset == digits.length()){	//已经得到一个符合条件的组合结果
			result.add(prefix);
			return;
		}
		String tempCharArray = charmap[digits.charAt(offset) - '0'];
		for(int k = 0; k < tempCharArray.length(); k++)
			combination(prefix + tempCharArray.charAt(k), digits, offset + 1, result);
	}
	
	public static void main(String[] args) {
		String num = "23";
		letterCombinations(num);
	}
}
 