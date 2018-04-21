package name.sophy.jianzhioffer;

import java.util.ArrayList;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月5日 下午12:59:39 
* Introduction of the class:
* 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
* 		思路一：利用快速排序划分的思想，知道pivot划分点正好是第k个，那么左边k个数就是要求的最小k个数字O(n)（可以修改输入数组的时候可用）
* 		思路二：利用最大堆或者红黑树（适合海量数据）
*/
public class GetLeastKNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length == 0)
        	return null;
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start ,end);
        while(index != (k-1)){
        	if(index > (k-1)){
        		index = partition(input, start, index - 1);
        	}
        	else{
        		index = partition(input, index + 1, end);
        	}
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
        	result.add(input[i]);
        }
        return result;
    }
    
    //快排划分
    public int partition(int[] input, int start, int end){
    	int pivot = input[end];
    	int i = start - 1;
    	for(int j = start; j < end ; j++){	//i表示当前确定小于pivot的最后一个元素的位置，j表示当前待判断的元素位置
    		if(input[j] <= pivot){	//如果当前元素比pivot小，需要交换到前面去；如果比pivot大的话，可以不需要管，直接遍历下一个元素
    			i++;
    			int temp = input[i];
    			input[i] = input[j];
    			input[j] = temp;
    		}
    	}
    	//最后交换pivot到中间（i+1）的位置
    	int temp = input[end];
		input[end] = input[i+1];
		input[i+1] = temp;
		for(int k = 0; k < input.length; k++)
			System.out.print(input[k] + " ");
		System.out.println();
    	return (i+1);	//返回pivot坐在index
    }
    
    public static void main(String[] args) {
		int [] input = {4,5,1,6,2,7,3,8};
		GetLeastKNumbers getLeastKNumbers = new GetLeastKNumbers();
		getLeastKNumbers.GetLeastNumbers_Solution(input, 4);
	}
    
    /*链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf
    	来源：牛客网

    	 public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    	       ArrayList<Integer> result = new ArrayList<Integer>();
    	       int length = input.length;
    	       if(k > length || k == 0){
    	           return result;
    	       }
    	        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
    	 
    	            @Override
    	            public int compare(Integer o1, Integer o2) {
    	                return o2.compareTo(o1);
    	            }
    	        });
    	        for (int i = 0; i < length; i++) {
    	            if (maxHeap.size() != k) {
    	                maxHeap.offer(input[i]);
    	            } else if (maxHeap.peek() > input[i]) {
    	                Integer temp = maxHeap.poll();
    	                temp = null;
    	                maxHeap.offer(input[i]);
    	            }
    	        }
    	        for (Integer integer : maxHeap) {
    	            result.add(integer);
    	        }
    	        return result;
    	    }
    	*/
}
 