package name.sophy.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月5日 上午10:23:03 
* Introduction of the class:字符串全排列
*/
public class Permutation {
	 public ArrayList<String> permutation(String str) {
		 ArrayList<String> result = new ArrayList<String>();
		 if(str == null || str.length() <= 0)
			 return result;
		 //递归思路，每次定下一个固定的位置，然后考虑剩下的排列
		 permutationIterator(str.toCharArray() , 0, result);//string不可修改，所以要将string转换成字符数组
		 Collections.sort(result);
		 return result;
	 }
	 
	 public void permutationIterator(char[] str , int index,  ArrayList<String> result){
		 //index表示要考虑交换的字符
		 if((index == str.length - 1) && (!result.contains(String.valueOf(str)))){	//如果已经是最后一个字符了，表示已经完成了一个排列，可以直接加入result中
			 result.add(String.valueOf(str));
		 }
		 else{	//考虑之后的所有字符与index这个位置的字符交换，然后考虑index+1之后的排列
			 for(int j = index; j < str.length; j++){
				 char temp = str[index];
				 str[index] = str[j];
				 str[j] = temp;
				 permutationIterator(str, index + 1, result);
				 temp = str[index];
				 str[index] = str[j];
				 str[j] = temp;
			 }
		 }
	 }
}
 