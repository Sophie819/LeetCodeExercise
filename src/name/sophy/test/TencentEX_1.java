package name.sophy.test;
import java.util.*;
public class TencentEX_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		System.out.println();
	}
	
	public int GCD(int a, int b) {	//最大公约数
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	public int LCD(int a, int b) {	//最小公倍数
		return (a * b) / (GCD(a, b));
	}
	
	//用一个数组a[n]存n个要求最小公倍数的数,分别为a[0]a[1]到a[n-1],先用辗转相除法GCD(a,b)求两个数最大公约数，然后LCD(a,b)=
	//a*b/ GCD(a,b)求最小公倍数，先求a[1]= LCD(a[0]a[1]),再求a[2]= LCD(a[1]a[2])，依次下去，最后a[n-1]=LCD(a[n-1]a[n-2])为结果。
	public int nLCD(int [] num, int n) {
		int [] a = new int[n];	//前i个数的最大公约数
		for(int i = 0; i < n; i++) {
			
		}
		return 0;
	}
}
