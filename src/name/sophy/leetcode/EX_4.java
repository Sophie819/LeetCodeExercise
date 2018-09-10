package name.sophy.leetcode;
/*
 * 2018.03.09
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class EX_4 {
	/*
	 * 方法一：这是最基本的方法，遍历两个数组，时间复杂度是O(m+n),其实并没有达到题目要求
	 * 方法二：分治，时间复杂度是O(log(m+n))
	 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int lenght2 = nums2.length;
        //考虑数组为空的边界条件
        if(length1 == 0){
        	return getMedianOfArray(nums2);
        }
        if(lenght2 == 0){
        	return getMedianOfArray(nums1);
        }
        	
        int size = length1 + lenght2;
        int mid = (length1 + lenght2) / 2;
        int [] nums3  = new int[size];
        int flag = (size % 2 == 0)? 1 : 0; 	//如果是偶数，需要计算中间两个数的均值；如果是基数则只需要那个中间数
        int temp1, temp2, tempCount; 
        int i = 0, j =0;
        for(tempCount = 0; tempCount < size; tempCount++){
        	//考虑遍历完某个数组的边界条件和处理方法
        	if(i < length1)
        		temp1 = nums1[i];
        	else
        		temp1 = Integer.MAX_VALUE;//因为每次都取较小的那个数值，所以如果某个数组已经遍历完，就将当前数值设置为max
        	if(j < lenght2)
        		temp2 = nums2[j];
        	else
        		temp2 = Integer.MAX_VALUE;
        	System.out.println(temp1 + ", " + temp2); 
        	if(temp1 < temp2){
        		nums3[tempCount] = temp1;
        		i++;
        	}
        	else{
        		nums3[tempCount] = temp2;
        		j++;
        	}
        	if(tempCount == mid)
        		break;
        }
        return (double)(nums3[mid] + nums3[mid-flag]) / 2.0;
    }
    
    public double getMedianOfArray(int[] nums){
    	int mid = nums.length / 2;
    	int flag = (nums.length % 2 == 0)? 1 : 0; 	//如果是偶数，需要计算中间两个数的均值；如果是基数则只需要那个中间数
    	return (double)(nums[mid] + nums[mid-flag]) / 2.0;
    }
    
    public static void main(String[] args) {
		EX_4 ex_4 = new EX_4();
		int[] nums1 = {1};
		int[] nums2 = {1};
		System.out.println("The median is " + ex_4.findMedianSortedArrays(nums1, nums2));
	}
}
