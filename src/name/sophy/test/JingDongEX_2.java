package name.sophy.test;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 2018.9.9京东笔试题2
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 * 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 */
public class JingDongEX_2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList<Product> arrayList = new ArrayList<Product>();
		for(int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			arrayList.add(new Product(a, b, c));
		}
		Collections.sort(arrayList, new Comparator<Product>() {
			public int compare(Product p1, Product p2) {
				if(p1.a != p2.a)
					return (p1.a - p2.a);
				else
					return (p1.b - p2.b);
			}
		});
		
		for(int i = 0; i < n; i++)
			System.out.println(arrayList.get(i).a  + " " + arrayList.get(i).b + " " + arrayList.get(i).c);
		
		int num = 0;
		for(int i = 0; i < n; i++) {
			Product p1 = arrayList.get(i);
			for(int j = i + 1; j < n; j++) {
				Product p2 = arrayList.get(j);
				if(p1.a < p2.a && p1.b < p2.b && p1.c < p2.c)
				{
					num++;
					break;
				}
			}
		}
		System.out.println(num);
	}
}

class Product{
	int a;
	int b;
	int c;
	public Product(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
