package name.sophy.easy;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 2017.11.03
 * 第三题：Given a string, find the length of the longest substring without repeating characters.
 * 先按照自己想的朴素的想法做一遍，再看solution，不然总是先看答案有什么意义呢
 */
public class EX_3 {
////!!!!!!time limitation!!!!!!时间复杂度在n^3
//	public int lengthOfLongestSubstring(String s) {
//		int tempMaxLenght = 0;
//		for(int i = 0; i < s.length(); i++){
//			for(int j = i; j < s.length(); j++){
//				if(!haveDuplicatedCharaters(s, i, j)){
//					tempMaxLenght = (tempMaxLenght > j - i + 1)?tempMaxLenght:(j - i + 1);
//				}
//			}
//		}
//		return tempMaxLenght;
//    }
//	
//	public boolean haveDuplicatedCharaters(String s, int begin, int end){
//		HashSet<Character> charSet = new HashSet<Character>();
//		for(int i = begin; i <= end; i++){
//			Character tempChar = s.charAt(i);
//			if(charSet.contains(tempChar))
//				return true;
//			else {
//				charSet.add(tempChar);
//			}
//		}
//		return false;
//	}
	
	//链接：https://www.nowcoder.com/questionTerminal/5947ddcc17cb4f09909efa7342780048 来源：牛客网

		/*
		    "滑动窗口" 
		    比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
		    然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
		    然后如果没有重复的就正常添加，
		    有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
		*/

		public int lengthOfLongestSubstring(String s) {
			s="abcabcc";
			if(s == null || s.length() == 0) return 0;
			//新建一个map进行存储char
			HashMap<Character,Integer> map = new HashMap<Character,Integer>();
			int leftBound = 0;
			int max = 0;
			for(int i=0; i<s.length();i++){
				char c = s.charAt(i);
				//窗口左边可能为下一个char，或者不变
				leftBound = Math.max(leftBound,(map.containsKey(c))? map.get(c)+1:0);
				max = Math.max(max, i-leftBound+1);//当前窗口长度
				map.put(c,i);
			}
			return max;
		}
}

