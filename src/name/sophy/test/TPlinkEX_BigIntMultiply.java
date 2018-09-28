package name.sophy.test;

import java.util.*;
public class TPlinkEX_BigIntMultiply {
    static int N = 100000;
    static int a[] = new int[N];
    static int b[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();
        int len1 = s1.length();
        int len2 = s2.length();
        getDigit(s1, a);
        getDigit(s2, b);
        output(multiply(a, len1, b, len2));
 
    }
 
    public static void output(int []arr) {
        boolean findFirstNum =  false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!findFirstNum && arr[i] == 0) {
                continue;
            }
            findFirstNum = true;
            System.out.print(arr[i]);
        }
        System.out.println();
    }
 
    public static int[] multiply(int []a, int len1, int []b, int len2) {
        int [] res = new int[2 * N + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int temp = res[j + i] + a[i] * b[j];
                int n = temp % 10;	//该位数值
                int m = temp / 10;	//进位
                res[i + j] = n;
                res[i + j + 1] += m;
            }
        }
        return res;
    }
 
    public static void getDigit(String s, int[] a) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            a[len - 1 - i] = s.charAt(i) - '0';	//小端存储，最高位存在数组高地址中
        }
    }
}


