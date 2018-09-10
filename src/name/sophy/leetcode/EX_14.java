package name.sophy.leetcode;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午8:30:43 
* Introduction of the class: 啊人家代码写的那么简洁，你写的这么杂乱有多！！！
*/
public class EX_14 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
        int shortestLength = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++){
			if(strs[i].length() < shortestLength)
				shortestLength = strs[i].length();
		}
		if(shortestLength == 0)
			return "";
		System.out.println(shortestLength);
		String tempCommonPrefix = "";
		int count = 0;
		for(int i = 0 ; i < shortestLength; i++){
			char tempChar = strs[0].charAt(count);
			for(int j = 0; j < strs.length; j++){
				if(strs[j].charAt(count) != tempChar)
					return tempCommonPrefix;
			}
			tempCommonPrefix += tempChar;
			count++;
		}
		return tempCommonPrefix;
    }
	
public static void main(String[] args) {
	String [] strs = {"abab","aba","abc"};
	EX_14 ex_14 = new EX_14();
	System.out.println(ex_14.longestCommonPrefix(strs));
}
}
 