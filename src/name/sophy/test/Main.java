package name.sophy.test;


/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月29日 下午3:47:52 
* Introduction of the class:
*/
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sx = in.nextInt();
        int sy = in.nextInt();
        int [][] h = new int[n][m];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++)
        		h[i][j] = in.nextInt();
        }
        
        boolean stop = false;
        while(!stop){
        	int tempH = h[sx - 1][sy - 1];
        	int nextSx = -1;
        	int nextSy = -1;
        	int nextH = -1;
        	if(sx - 1 >= 1 && h[sx - 2][sy - 1] > tempH){	//向上
        		nextSx = sx - 1;
        		nextSy = sy;
        		nextH = h[sx - 2][sy - 1];
        	}
        	if(sx + 1 <= n && h[sx][sy - 1] > tempH){	//向下
        		nextSx = sx;
        		nextSy = sy;
        		nextH = h[sx][sy - 1];
        	}
        	if(sy - 1 >= 1 && h[sx - 1][sy - 2] > tempH){	//向左
        		nextSx = sx;
        		nextSy = sy - 1;
        		nextH = h[sx - 1][sy - 2];
        	}
        	if(sy + 1 <= m && h[sx - 1][sy] > tempH){	//向右
        		nextSx = sx;
        		nextSy = sy + 1;
        		nextH = h[sx - 1][sy];
        	}
        	if(nextSx == -1 && nextSy == -1 && nextH == -1)
        		stop = true;
        }
        System.out.println(h[sx - 1][sy - 1]);
	}
}
