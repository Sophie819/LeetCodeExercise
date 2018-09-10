package name.sophy.easy;
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午8:30:43 
* Introduction of the class: 啊人家代码写的那么简洁，你写的这么杂乱有多！！！
*/
public class EX_014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        /*纵向搜索
        if(strs.length == 0)
			return "";
        int shortestLength = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++){
			if(strs[i].length() < shortestLength)
				shortestLength = strs[i].length();
		}
		if(shortestLength == 0)
			return "";
		
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
		return tempCommonPrefix;*/
        
        //横向搜索
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
 