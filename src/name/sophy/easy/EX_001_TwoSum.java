package name.sophy.easy;

import java.util.HashMap;

/*
	2017.11.02 
	ex_1
	 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	   	You may assume that each input would have exactly one solution, and you may not use the same element twice.
		Example:
			Given nums = [2, 7, 11, 15], target = 9,
			Because nums[0] + nums[1] = 2 + 7 = 9,
			return [0, 1].
 */
public class EX_001_TwoSum {
	//时间复杂度O(n^2)，空间复杂度O(1)
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
        	for(int j = i; j < nums.length; j++){
        		if(nums[i] + nums[j] == target)
        			return new int []{i , j};
        	}
        }
        System.out.println("No such numbers");
        return new int[]{-1, -1};
    }
    
    //第二种思路，用到hash表存储数组中的元素及其index，考虑target-nums[i]是否存在，时间复杂度O(n)，空间复杂度O(n)
    public int[] twoSum_1(int [] nums, int target){
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0 ;i < nums.length; i++){
    		int comp = target - nums[i];
    		if(map.containsKey(comp))
    			return (i < map.get(comp))?new int[]{i, map.get(comp)} : new int[]{map.get(comp), i};
    		map.put(nums[i], i);
    	}
    	throw new IllegalArgumentException("No two sum solution");
    }
}
