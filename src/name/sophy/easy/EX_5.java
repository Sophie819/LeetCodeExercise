package name.sophy.easy;


/*
 * 2018.03.12
 * 最长回文子串
 * Approach #1 (Longest Common Substring) [Accepted] 注意：该方法并不完善!
 * Approach #2 (Brute Force) [Time Limit Exceeded] 注意：时间复杂度是O(n^3)
 * Approach #3 (Dynamic Programming) [Accepted]	注意：时间复杂度是O(n^2)
 * Approach #4 (Expand Around Center) [Accepted]
 */
public class EX_5 {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
    	int [][] p = new int[s.length()][s.length()];	//p[i][j]=0或者1表示s[i,j]是否是回文子串，初始化为0
    	for(int i = 0 ; i < s.length(); i++)	//由于顺序问题，提前将数组对角线全部初始化为1
			p[i][i] = 1;
    	for(int i = 0; i < s.length() - 1; i++)
    		if(s.charAt(i) == s.charAt(i + 1))
    			p[i][i + 1] = 1;
    	for(int length = 3; length <= s.length(); length++){
    		for(int i = 0; i < s.length() - length + 1; i++){
    			int j = i + length - 1;
    			if(s.charAt(i) == s.charAt(j))
					p[i][j] = p[i+1][j-1];
    		}
    	}
    	
    	for(int i = 0; i < p.length; i++){
    		for(int j = 0; j < p.length; j ++)
    			System.out.print(p[i][j] + ", ");
    		System.out.println();
    	}
    	for(int i = 0; i < s.length(); i++){
    		for(int j = i ; j < s.length(); j++){
    			if(p[i][j] == 1 && (j - i) > (end - start))
    			{
    				end = j;
    				start = i;
    			}
    		}
    	}
        return s.substring(start, end + 1);
    }
    
    public static void main(String[] args) {
		EX_5 ex_5 = new EX_5();
		System.out.println(ex_5.longestPalindrome("abcba"));
	}
}
