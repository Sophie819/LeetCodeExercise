package name.sophy.easy;
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
public class EX_1 {
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
    
    public static void main(String[] args) {
    	String string = null;
    	string.concat("abd");
    	string.concat("1234");
    	System.out.println(string);
    }
}
