package name.sophy.hard; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月10日 下午6:17:15 
* Introduction of the class:
*/
public class EX_010_RegularExpressionMatching {
	 public boolean isMatch(String s, String p) {
	        if(s == null && p == null)
	            return true;
	        if(s != null && p == null)
	            return false;
	        return isMatchCore(s, 0, p, 0);
	    }
	    
	    public boolean isMatchCore(String s , int sIndex, String p ,int pIndex){
	        if(sIndex == s.length() && pIndex == p.length())    //匹配成功
	            return true;
	        if(sIndex < s.length() && pIndex == p.length())     //s还有剩余的字符无法匹配，失败；p还有剩余的字符未匹配完，可能成功，也可能失败，需要继续进行匹配
	            return false;
	        //第二个字符是*
	        if((pIndex < p.length() - 1) && p.charAt(pIndex + 1) == '*'){
	            if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) //如果当前第一个字符匹配，pattern后移两位或者string后移一位      
	                return isMatchCore(s, sIndex, p, pIndex + 2) || isMatchCore(s, sIndex + 1, p, pIndex);
	            else                                        //如果当前第一个字符不匹配，pattern后移两位，相当于匹配0个字符
	                return isMatchCore(s, sIndex, p, pIndex + 2);
	        }
	        //第二个字符不是*，考虑当前字符是否匹配即可，注意.可以匹配任意字符
	        if(sIndex < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)))
	            return isMatchCore(s, sIndex + 1, p, pIndex + 1);
	        else
	            return false;
	    }
	    
	    /*看人家的代码写得多么简洁
	    public boolean isMatch(String text, String pattern) {
	        if (pattern.isEmpty()) return text.isEmpty();
	        boolean first_match = (!text.isEmpty() && 
	                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
	        
	        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
	            return (isMatch(text, pattern.substring(2)) || 
	                    (first_match && isMatch(text.substring(1), pattern)));
	        } else {
	            return first_match && isMatch(text.substring(1), pattern.substring(1));
	        }
	    }
	    */
}
 