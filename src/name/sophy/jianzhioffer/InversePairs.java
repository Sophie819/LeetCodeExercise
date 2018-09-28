package name.sophy.jianzhioffer;

import java.util.*;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年4月16日 下午3:20:40 
* Introduction of the class:求数组中的逆序对
*/
public class InversePairs {
	  public int inversePairs(int [] array) {
	        return mergeSort(array, 0, array.length - 1);
	  }
	  
	 public static int merge(int[] a, int low, int mid, int high) {	//返回逆序对的数目，即是进行交换的次数
	        int count = 0;	
		 	int[] temp = new int[high - low + 1];
	        int i = mid;// 左指针
	        int j = high;// 右指针
	        int k = high - low;
	        // 把较小的数先移到新数组中
	        while (i >= low && j > mid) {
	            if (a[i] <= a[j]) {
	                temp[k--] = a[j--];
	            } else {
	                temp[k--] = a[i--];
	                count += j - mid;
	                if(count >= 1000000007)
	                	count %= 1000000007;
	            }
	        }
	        // 把左边剩余的数移入数组
	        while (i >= low) {
	            temp[k--] = a[i--];
	        }
	        // 把右边边剩余的数移入数组
	        while (j > mid) {
	            temp[k--] = a[j--];
	        }
	        // 把新数组中的数覆盖nums数组
	        for (int k2 = 0; k2 < temp.length; k2++) {
	            a[k2 + low] = temp[k2];
	        }
	        return count;
	    }

	    public static int mergeSort(int[] a, int low, int high) {
	        int mid = (low + high) / 2;
	        int num1 = 0, num2 = 0, num3 = 0;
	        if (low < high) {
	            // 左边
	            num1 = mergeSort(a, low, mid)%1000000007;
	            // 右边
	            num2 = mergeSort(a, mid + 1, high)%1000000007;
	            // 左右归并
	            num3 = merge(a, low, mid, high)%1000000007;
	            //System.out.println(Arrays.toString(a));
	        }
	        return (num1 + num2 + num3)%1000000007;
	    }
	    
	    public static void main(String[] args) {
			int [] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
	    		InversePairs inversePairs = new InversePairs();
			System.out.println(inversePairs.inversePairs(array));
		}
}
 