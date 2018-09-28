package name.sophy.test;
/*
 * 20180914:统计数组中各个key的数量，数量多的排在前面，如果数量相等就把最早出现的排在前面，其实很简单，自己太不熟练了
 * 
 */
import java.util.*;
public class BaiduEX_3 {
	public List<Integer> sortAarray(int n, int [] sal){
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75f, true);	//按照添加顺序排序
		for(int i = 0; i < n; i++) {
			if(map.containsKey(sal[i])) {
				map.replace(sal[i], map.get(sal[i]) + 1);
			}
			else
				map.put(sal[i], 1);
		}
		
		List<Map.Entry<Integer, Integer>> infos = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		for(Map.Entry<Integer, Integer> temp : infos)
			System.out.println(temp.getKey() + " : " + temp.getValue());
		
		Collections.sort(infos, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if(o1.getValue() < o2.getValue())
					return 1;
				else if(o1.getValue() == o2.getValue())
					return 0;	//o1, o2相等,o1在o2之前
				else 
					return -1;
			}
		});
		
		for(Map.Entry<Integer, Integer> entry : infos) {
			int times = entry.getValue();
			for(int i = 0; i < times; i++) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		BaiduEX_3 baiduEX_3 = new BaiduEX_3();
		int [] sal = {5, 1, 3, 4, 1, 2, 2, 9, 8, 5, 1};
		int n = 11;
		List<Integer> result = baiduEX_3.sortAarray(n, sal);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
