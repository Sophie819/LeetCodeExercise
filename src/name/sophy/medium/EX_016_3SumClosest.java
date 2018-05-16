package name.sophy.medium;

import java.util.Arrays;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月15日 下午4:47:14 
* Introduction of the class:
*/
public class EX_016_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            System.err.println("Error input!");
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int tempSum = nums[i] + nums[low] + nums[high];
                if(tempSum == target)
                    return target;
                else if(tempSum < target)
                    low++;
                else
                    high--;
                if(Math.abs(tempSum - target) < Math.abs(closet - target))
                    closet = tempSum;
            }
        }
        return closet;
    }
}
 