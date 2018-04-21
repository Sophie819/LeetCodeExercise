package name.sophy.easy;
import java.util.ArrayList;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午6:35:15 
* Introduction of the class:
*/
public class EX_7 {
	public int reverse(int x) {
		int result=0;
		  while(x!=0) {
		   int tail=x%10;
		   int newResult=result*10+tail;
		   if((newResult-tail)/10!=result) { //If overflow exists, the new result will not equal previous one.
		    return 0;
		   }
		   result=newResult;
		   x=x/10;
		  }
		  return result;
    }
	
	public static void main(String[] args) {
		EX_7 ex_7 = new EX_7();
		System.out.println(ex_7.reverse(1534236469));
	}
}
 