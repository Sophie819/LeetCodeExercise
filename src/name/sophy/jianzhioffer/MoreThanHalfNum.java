package name.sophy.jianzhioffer;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月5日 下午12:12:47 
* Introduction of the class:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
* 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/
public class MoreThanHalfNum {
	//思路一：基于快速排序Patition的思想，直到正好分割点是正中间的那个点为止O(n)
	//思路二：考虑数组特点，每次遇到一个新的数字，次数减一；遇到一样的，次数加一；如果次数为0，就保存新的数字，并且次数设置为1.
	//		最后一次把次数设为1时对应的数字就是所求P165,O(n)
	//解法三：用sort排序，然后取中位数O(nlogn)
	//解法四：用HashMap记录每个数字对应的出现次数，O(n)
	//注意：最后都需要进行判断是否是合法的出现次数超过数组个数的一半，否则返回0
    public int moreThanHalfNum_Solution(int [] array) {
    	Arrays.sort(array);
    	int result = array[(array.length - 1)/2];
    	int count = 0;
    	for(int i = 0; i < array.length; i++)
    		if(array[i] == result)
    			count++;
    	
    	return (count >= (array.length / 2))?result : 0;
    }
}
 