package name.sophy.jianzhioffer;

import java.util.LinkedHashMap;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午3:08:23 
* Introduction of the class:
*/
public class FirstNotRepeatingChar {
	public int firstNotRepeatingChar(String str) {
        /*
        if(str == null || str.length() <= 0)
            return -1;
        for(int i = 0; i < str.length(); i++)
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
                 return i;       
        return 0;
        */
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++)
			if(map.get(str.charAt(i)) != null)
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			else
				map.put(str.charAt(i), 1);
		
		int pos = -1;
		for(int i = 0; i < str.length(); i++){
			if(map.get(str.charAt(i)) == 1)
				return i;
		}
		return pos;
    }
}
 