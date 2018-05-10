package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月4日 下午4:00:45 
* Introduction of the class:
*/
import java.util.*;
public class GetMedian {
    //当海量数据的时候，需要考虑最大堆或者最小堆
    //用两个堆，一个最大堆，一个最小堆，保证最大堆的所有元素都小于等于最小堆，而且两个对的数目差小于等于1
    //如果两个堆中元素数目一样，就取最大堆的最大数和最小堆的最小数的平均值，如果最大堆多1个元素，就是最小堆的最小值
    //当前两个堆，奇数元素插入最大堆，偶数元素插入最小堆
    //Max，Min
    //如果需要插入Min的元素比Max小，那么将该元素插入Max，然后取Max中的最大值插入Min即可
    //如果需要插入Max的元素比Min大，那么将该元素插入Min，然后取Min中的最小值插入Max即可
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();//最小堆，index为偶数的元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(18, Collections.reverseOrder());
    /*new comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2){
            return o2 - o1;    //从大到小排序
        }
    });//最大堆，index为奇数的元素*/
    
    public void Insert(Integer num) {
        if(((minHeap.size() + maxHeap.size()) & 1) == 0){//当前两个堆的数目之和为偶数，就将新元素插入Min
            if(maxHeap.size() > 0 && num < maxHeap.peek()){//如果需要插入Min的元素比Max小，那么将该元素插入Max，然后取Max中的最大值插入Min即可
                maxHeap.offer(num);
                num = maxHeap.poll();
            }    
            minHeap.offer(num);
        }
        else{    //当前两个堆的数目之和为奇数，就将新元素插入Max
            if(maxHeap.size() > 0 && num > maxHeap.peek()){//如果需要插入Max的元素比Min大，那么将该元素插入Min，然后取Min中的最小值插入Max即可
                minHeap.offer(num);
                num = minHeap.poll();
            }    
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        return 0.0;
    }


}