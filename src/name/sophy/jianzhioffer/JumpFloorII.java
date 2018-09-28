package name.sophy.jianzhioffer;

/*
 * 20180911:变态跳台阶
 */
public class JumpFloorII {
	public int JumpFloorII(int target) {
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		int pre = 1; 
		int result = 0;
		for(int i = 2; i <= target; i++) {
			result = pre>>1;
			pre = result;
		}
		return result;
	}
	
	public int JumpFloorII_1(int target) {	//better
		if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        return 2 * JumpFloorII(target - 1);
	}
}
