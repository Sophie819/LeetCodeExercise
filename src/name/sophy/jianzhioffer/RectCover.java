package name.sophy.jianzhioffer;
/*
 * 20180911:矩形覆盖
 * 思路：递归，本质上市斐波那契数列
 */
public class RectCover {
	public int RectCover_1(int target) {
		if(target <= 2)
			return target;
		int p1 = 1;
		int p2 = 2;
		for(int i = 3; i <= target; i++) {
			int temp = p2;
			p2 = p1 + p2;
			p1 = temp;
		}
		return p2;
	}
	
	public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
