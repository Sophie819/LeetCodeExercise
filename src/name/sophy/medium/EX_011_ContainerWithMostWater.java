package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月15日 下午12:35:19 
* Introduction of the class:
*/
public class EX_011_ContainerWithMostWater {
	//用到双指针的思想
    //因为容量至于两个指针中最短的那个和两指针之间的距离相关
    //所以当左<右，左++（如果右—的话，只能获得比现在更少的容量，因为左指针的长度已经限制了）；当左>=右，右--
    public int maxArea(int[] height) {
        int begin  = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while(begin < end){
            maxArea = Math.max( maxArea, Math.min(height[begin], height[end]) * (end - begin));
            if(height[begin] < height[end])
                begin++;
            else
                end--;
        }
        return maxArea;
    }
}
 