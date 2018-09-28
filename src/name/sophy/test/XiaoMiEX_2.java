package name.sophy.test;
/*
 * 将数组（大小为n）切分成m个段，使得这些段的最大值最小，求这样的划分（百度到思路，注意是数组不是集合，切分必须要正一个段里面的数字是连续的）
 */
import java.util.*;
public class XiaoMiEX_2{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        
        int [][] dp = new int[10000][10000];	//dp[i][j]表示前i个数分成j段的最小最大值
       
        for(int i = 1; i <= n ;i++)	//j == 1
        		dp[i][1] = dp[i - 1][1] + a[i - 1];
        //for(int i = 1; i <= n; i++)
        		//System.out.println(dp[i][1]);
        for(int i = 1; i <= n; i++) {//j >= 2
        		for(int j = 2; j <= m; j++) {
        			int min_max = Integer.MAX_VALUE;
        			for(int k = 1; k <= i; k++) {
        				min_max = Math.min(min_max, Math.max(dp[i][1] - dp[k][1], dp[k][j - 1]));
        			}
        			dp[i][j] = min_max;
        			System.out.println(i + ", " + j + " : " + dp[i][j]);
        		}
        }
        System.out.println(dp[n][m]);    
    }   
}
    
   