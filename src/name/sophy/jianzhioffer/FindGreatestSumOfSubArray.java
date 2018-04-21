package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 上午9:23:13 
* Introduction of the class:连续子数组的最大和
*/
public class FindGreatestSumOfSubArray {
	public int findGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length <= 0)
			return 0;
		
		int [] p = new int[array.length];//记录以第i个元素结尾（一定包含第i个元素）的连续子数组的最大和
		p[0] = array[0];
		for(int i = 1; i < array.length; i++){
			if(p[i - 1] <= 0){
				p[i] = array[i];
			}
			else{//p[i-1] > 0
				p[i] = p[i - 1] + array[i];
			}
		}
		return getMax(p);
	}
	
	public int getMax(int [] array){
		int max = -99999999;
		for(int i = 0; i < array.length; i++){
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
}
 