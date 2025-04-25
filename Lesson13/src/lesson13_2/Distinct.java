package lesson13_2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Distinct {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		System.out.println(list);
		list = new ArrayList<>(new LinkedHashSet(list));  //hash코드 값과 equals가 일치할 때 중복
		//오름차순으로 만들고 싶으면 TreeHas쓰면됨
		//new를 두번써서 다른주소가 2개생김
		//중복제거하기 위해 set자료구조 쓰고 다시 list로 만들기
		System.out.println(list);
		
	}
}
