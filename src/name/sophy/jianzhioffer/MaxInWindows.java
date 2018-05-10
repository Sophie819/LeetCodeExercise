package name.sophy.jianzhioffer; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月4日 下午4:57:52 
* Introduction of the class:
*/
import java.util.*;
public class MaxInWindows {
    //考虑当前最有可能成为滑动窗口最大值的那个数
    //用到一个双向队列，可以从两端取数据，记录当前可能是滑动窗口最大值的数字的下标，队列头部是当前最大值
    //1.当向队列中插入元素的时候，考虑队列中是否有元素小于该元素，如果有，将这些元素从队列尾部删除
    //2.当队列中元素超过滑动窗口的数目，需要将元素从队列头部删除
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        if(num == null || num.length < size || size <= 0)
            return res;
        for(int i = 0; i < num.length; i++){
        	for(Integer temp:deque)
        		System.out.print(temp);
        	System.out.println();
            int begin  = i - size + 1;//理论上当前滑动窗口的头部的index
            if(deque.isEmpty())//当前队列为空，直接入队列（注意是元素的index）
                  deque.offerLast(i);    
            else if(deque.getFirst() < begin)//判断当前最大值是否需要保留
                deque.pollFirst();
            while(!deque.isEmpty() && (num[deque.getLast()] <= num[i])){    //删除队列中小于当前值的元素
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= size - 1){
                res.add(deque.peekFirst());
                System.out.println(deque.peekFirst());
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int [] num = {2,3,4,2,6,2,5,1};
    	MaxInWindows maxInWindows = new MaxInWindows();
    	maxInWindows.maxInWindows(num, 3);
	}
}