package lesson13_2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		
		map.put("B", 20);
		Integer j = map.put("B", 30);  //put에는 반환값이 있음. value는 int니까 int로 하면 덮어진 수가나옴. null이면 터짐
		int i = map.put("B", 30); 
		map.put("C", 50);
		System.out.println(map);
		
		Set<String> keys = map.keySet(); //key가져오면 set으로 만든다는 뜻
		System.out.println(keys);
		
		List<Integer> v1 = new ArrayList<Integer>(map.values());
		Set<Integer> v2 = new HashSet<Integer>(map.values());
		System.out.println(v1);
		System.out.println(v2);
		
		Set<Entry<String, Integer>>s = map.entrySet();
		for(Entry<String, Integer> e: s	) {
			System.out.println(e.getKey()+ "::"+ e.getValue());
		}
		Properties properties = new Properties(); 
	}
}
