package lesson13_2;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("새똥이");
		set.add("말똥이");
		set.add("개똥이");
		set.add("1");
		set.add("2");
		set.add("9");
		set.add("10");
		
		
		
		System.out.println(set); //사전나열순으로 정렬됨/ 1,10,2,9로 나옴. 문자열이라서 
		
		Set<Integer> set2 = new TreeSet<>();
		set2.add(1);
		set2.add(2);
		set2.add(9);
		set2.add(10);
		System.out.println(set2); //이건 integer이라서 1,2,9,10으로 나옴
		
		Set<Addr> set3 = new TreeSet<>();
		set3.add(new Addr("개똥이","1234"));
		set3.add(new Addr("새똥이","5678"));
		System.out.println(set3);  //내림차순하고싶으면 숫자부정(음수) 쓰기
		//기준이 정해져있지 않아서 오류남. tree는 비교 인터페이스가 필요함. 
	}
}
