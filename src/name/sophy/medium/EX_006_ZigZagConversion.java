package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月10日 上午11:25:41 
* Introduction of the class:
*/
public class EX_006_ZigZagConversion {
	//主要思路：用一个数组存储每一行的字符，元素个数为numRows，设置index表示当前这个字符应该加到数组中哪个index上，incre表示增量
    public String convert(String s, int numRows) {
    	if(numRows <= 1)	//异常处理
            return s;
    	StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
        	sb[i] = new StringBuffer("");//需要手动初始化，否则会出现空指针的错误
        int index = 0;
        int incre = 1;
        for(int i = 0; i < s.length(); i++){
            sb[index].append(s.charAt(i));
            if(index == 0)
                incre = 1;
            else if(index == numRows - 1)
                incre = -1;
            index += incre;
        }
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < numRows; i++)
        	result.append(sb[i]);
        return result.toString();
    }
}
 