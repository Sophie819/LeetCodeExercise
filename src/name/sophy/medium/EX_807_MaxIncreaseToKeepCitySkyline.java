package name.sophy.medium; 
/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年5月7日 下午12:09:15 
* Introduction of the class:
* https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
*/
public class EX_807_MaxIncreaseToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //计算第i行的最大值，并且计算第i列的最大值
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                result += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return result;
    }
}
 