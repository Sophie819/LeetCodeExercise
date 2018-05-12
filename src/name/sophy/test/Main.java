package name.sophy.test;


import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		int n = in.nextInt();	//点数
        int m = in.nextInt();	//边数
        in.nextInt();
        int [][] edge = new int [n][n];
        int result = 0;	//所有的路径数量
        for(int i = 0; i < m; i++){
        	int a = in.nextInt();
        	int b = in.nextInt();
        	edge[a][b] = 1;
        }
        /*for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++)
        		System.out.print(edge[i][j]);
        	System.out.println();
        }*/
        //用一个栈记录当前路径，用一个visited表示所有出边可达的点是否已经被访问过
        Stack<Integer> path = new Stack<Integer>();
        int[][] visited = new int[n][n];
        path.push(0);
        while(!path.isEmpty()){
	        int tempNode = path.peek();
	        //System.out.println("top : " + tempNode);
	        int ifPop = 0;
        	for(int i = 0; i < n; i++){	//考虑从当前tempNode点的未被访问过的出边
	        	if(edge[tempNode][i] == 1 && visited[tempNode][i] == 0){
	        		path.push(i);
	        		visited[tempNode][i] = 1;
	        		ifPop = 1;
	        		break;
	        	}
	        }
        	//如果改点没有找到未访问过的出边，那就将改点弹出，并且已经找到一条路径了
        	if(ifPop == 0){
        		result++;
            	path.pop();
            	for(int i = 0; i < n; i++)
            		visited[tempNode][i] = 0;
            	//System.out.println("pop");
        	}
        }
        System.out.println(result - 1);
	}
}
