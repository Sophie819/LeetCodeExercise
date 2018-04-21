package name.sophy.test;

import java.util.*;
import java.util.Map.Entry;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月28日 下午9:12:04 
* Introduction of the class:
*/
public class Input {
	
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
        String str = in.next();
        if(str == null || str.length() <= 0)
        	return;
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
        	char temp = str.charAt(i);
        	if(map.containsKey(temp)){
        		map.put(temp, map.get(temp) + 1);
        	}
        	else{
        		map.put(temp, 1);
        	}
        }
        char[] result =  new char[str.length()];
        int count = 0;
        while(!map.isEmpty()){
        	Object [] keySet = map.keySet().toArray();
             for(int i = 0; i < keySet.length; i++) {
            	 char tempKey = (char) keySet[i];
                 result[count] = tempKey;
                 if(map.get(tempKey) == 1){
                	 map.remove(tempKey);
                 }
                 else{
                	 map.put(tempKey, map.get(tempKey) - 1);
                 }
                 count++;
             }
        }
        System.out.println(result);
	}
	
	
}
 