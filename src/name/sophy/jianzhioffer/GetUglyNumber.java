package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午6:02:51 
* Introduction of the class:把只包含因子2、3和5的数称作丑数（Ugly Number）。
* 		例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/
public class GetUglyNumber {
	public int getUglyNumber_Solution(int index) {
		if(index <= 0)
			return 0;
		int[] uglyNumber = new int[index];
		uglyNumber[0] = 1;	//初始化第一个丑数
		int nextIndex = 1;	//下一个丑数的index
		
		int mul2 = 0;	//第一个乘以2后大于M（当前最大的丑数）的结果（存储的是数组中的index）
		int mul3 = 0;	//第一个乘以3后大于M（当前最大的丑数）的结果
		int mul5 = 0;	//第一个乘以5后大于M（当前最大的丑数）的结果
		
		while(nextIndex < index){
			int min = Math.min(uglyNumber[mul2] * 2, Math.min(uglyNumber[mul3] * 3, uglyNumber[mul5] * 5));
			uglyNumber[nextIndex] = min;	//设置当前计算的三个值中的最小值
			//下面计算数组中第一个乘以2以后大于当前最大值min的index
			while(uglyNumber[mul2] * 2 <= uglyNumber[nextIndex]){
				mul2++;
			}
			while(uglyNumber[mul3] * 3 <= uglyNumber[nextIndex]){
				mul3++;
			}
			while(uglyNumber[mul5] * 5 <= uglyNumber[nextIndex]){
				mul5++;
			}
			nextIndex++;
		}
		return uglyNumber[index - 1];
    }
}
 