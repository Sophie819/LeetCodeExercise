package name.sophy.jianzhioffer;
/*
 * 20180911：斐波那契数列
 * 思路：递归每次都要重新计算f(0)~f(n - 1)，应该把之前计算过的存储下来，这样可以节省时间。
 */
public class Fibonacci {
	
	public int Fibonacci(int n) {
		/*if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
		*/
		
		if (n < 1) 
			return 0;
		if (n == 1 || n == 2) 
			return 1;
		int f1 = 1, f2 = 1, ans = 0;
		for (int i = 3; i <= n; i++)
		{
			ans = f2 + f1;
			f1 = f2;
			f2 = ans;
		}
		return ans;
    }
}
