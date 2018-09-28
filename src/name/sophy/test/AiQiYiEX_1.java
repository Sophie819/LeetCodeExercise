package name.sophy.test;
import java.util.*;
/*
 * poj 1422 二分图 最小路径覆盖
 */
public class AiQiYiEX_1 {
	int maxn = 5000;
	int [][] map = new int [maxn][maxn];
	int [] visited = new int[maxn];
	int [] match = new int[maxn];
	int n;
    public static void main(String[] args) {
    		AiQiYiEX_1 ma = new AiQiYiEX_1();
    		Scanner scanner = new Scanner(System.in);
        ma.n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < ma.n; i++)
        		a.add(scanner.nextInt());
        ma.constructMap(a);
        System.out.println(ma.n - ma.hungry());
	}
    
    public boolean dfs(int v) {
    		for(int i = 0; i < n; i++) {
    			if(map[v][i] == 1 && visited[i] == 0) {
    				visited[i] = 1;
    				if(match[i] == -1 || dfs(match[i]) ) {
    					match[i] = v;
    					return true;
    				}
    			}
    		}
    		return false;
    }
    
    public int hungry() {
    		int ans = 0;
    		for(int i= 0; i < match.length; i++)
    			match[i] = -1;
    		for(int i = 0; i < n; i++) {
    			for(int j = 0; j < visited.length; j++)
    				visited[j] = 0;
    			if(dfs(i))
    				ans++;
    		}
    		return ans;
    }
    
    public void constructMap(ArrayList<Integer> a) {
    		//从小大大排序
        Collections.sort(a);
        //构建map，对于两个点（a,b）如果a < b，那么有一条边从a指向b
        for(int i = 0; i < a.size(); i++) {
        		for(int j = i + 1; j < a.size(); j++) {
        			if(a.get(i) < a.get(j))
        				map[i][j] = 1;
        		}
        }
    }
}