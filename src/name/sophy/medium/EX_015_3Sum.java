package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月15日 下午2:04:53 
* Introduction of the class:注意需要考虑有元素重复的情况处理
*/
import java.util.*;
public class EX_015_3Sum {
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(nums == null || nums.length < 3)
	            return result;
	        
	        Arrays.sort(nums);
	        for(int i = 0; i < nums.length - 2; i++){
	            if(i == 0 || (i > 0 && nums[i - 1] != nums[i])){    //以免产生相同的结果
	            	int tempSum = - nums[i];
	                int low = i + 1;
	                int high = nums.length - 1;
	                while(low < high){
	                    if(nums[low] + nums[high] == tempSum){
	                        List<Integer> tempList = new ArrayList<Integer>();
	                        tempList.add(nums[i]);
	                        tempList.add(nums[low]);
	                        tempList.add(nums[high]);
	                        result.add(tempList);
	                        while(low < high && nums[low + 1] == nums[low])	    //跳过哪些相等的元素,以免产生相同的结果
	                        	low++;
	                        while(low < high && nums[high - 1] == nums[high])
	                        	high--;
	                        low++;		//只有这样才可能产生和为tempSum的两个元素
	                        high--;
	                    }
	                    else if(nums[low] + nums[high] < tempSum)
	                        low++;
	                    else
	                        high--;
	                }
	            }
	        }
	        return result;
	    }
}
 