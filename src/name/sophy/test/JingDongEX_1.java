package name.sophy.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * 2018.9.9京东笔试题1
 * 多部图问题，将一个简单无向无环图，点分成若干个集合，使得每个集合中的点都不相邻，每两个集合中的点都是相邻的，判断是否是多部图.
 * 思路是判断那些不存在图中的边，这些边邻接的点一定在同一个点集中，然后判断每两个点集中的点是否都有边相连（其实就是暴力搜索法）
 * eg.点数为5，边数为7的一个图，就是多部图，可以分成两个点集{3，5}和{1，2，4}
 * 1 3
 * 1 5
 * 2 3
 * 2 5
 * 2 4
 * 3 5
 * 4 5
 */
public class JingDongEX_1{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
        boolean [] result = new boolean[t];
		for(int i = 0; i < t; i++){
        	int n = scanner.nextInt();//点数
            int m = scanner.nextInt();//边数
            int [][] graph = new int[n][n];
            for(int j = 0; j < m; j++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph[a - 1][b - 1] = 1;
                result[i] = judge(graph, n);
            }
        }
		for(int i = 0; i < t; i++)
			System.out.println(result[i]);
	}
            
    public static boolean judge(int [][] graph, int n){
        ArrayList<HashSet<Integer>> node = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++)
            {
                if(graph[i][j] == 0){	//如果这条边不在
                    boolean flag = false;
                    for(int k = 0; k < node.size(); k++){
                    	if(node.get(k).contains(i)){
                            node.get(k).add(j);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        HashSet<Integer> s = new HashSet<Integer>();
                        s.add(i);
                        s.add(j);
                    	node.add(s);
                    }
                }
            }
        }
        for(int i = 0; i < node.size() - 1; i++){
            for(int j = i + 1; j < node.size(); j++){
                for(Integer node_1 : node.get(i)) {
                		for(Integer node_2 : node.get(j)) {
                			if(graph[node_1][node_2] == 0)
                				return false;
                		}
                }
            }
        }
        return true;
    }
}	
    
   