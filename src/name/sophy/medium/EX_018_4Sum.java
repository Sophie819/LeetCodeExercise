package name.sophy.medium;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月15日 下午5:48:53 
* Introduction of the class:
* 		写的太复杂了，时间复杂度很高，参考一下别人的代码
* 		https://leetcode.com/problems/4sum/discuss/8575/Clean-accepted-java-O(n3)-solution-based-on-3sum
*/
public class EX_018_4Sum {
	 public List<List<Integer>> fourSum(int[] nums, int target) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
	     if(nums == null || nums.length < 4)
	    	 return result; 
	     
	     Arrays.sort(nums);   
	     for(int i = 0; i < nums.length - 3; i++){
	    	 if(i == 0 || (i > 0 && nums[i - 1] != nums[i])){
	    		 List<List<Integer>> threeSumResult = threeSum(nums, i + 1, target - nums[i]);
	    		 for(int j = 0; j < threeSumResult.size(); j++){
	    			 threeSumResult.get(j).add(0, nums[i]);
	    			 result.add(threeSumResult.get(j));
	    		 }
	    	 }
	     }
	     return result;
	 }
	 
	 public List<List<Integer>> threeSum(int[] nums, int offset, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for(int i = offset; i < nums.length - 2; i++){
            if(i == offset || (i > offset && nums[i - 1] != nums[i])){    //以免产生相同的结果
            	int tempSum = target - nums[i];
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
	 
	 public static void main(String[] args) {
		 int [] nums = {1,0,-1,0,-2,2};
		EX_018_4Sum ex_018_4Sum = new EX_018_4Sum();
		ex_018_4Sum.fourSum(nums, 0);
	}
}
 