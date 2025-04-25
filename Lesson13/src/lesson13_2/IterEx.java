package lesson13_2;

import java.util.Iterator;
import java.util.Set;

public class IterEx {
	public static void main(String[] args) {
		Set<Integer> set = Set.of(10,20,30,40,50);
		System.out.println(set);
		
		Iterator<Integer> it = set.iterator(); //반환타입이 Iterator객체가됨
//		System.out.println(it.next());
//		System.out.println(it.next()); //다음 노드 탐색
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next()); //커서는 이전방향으로 못감
//		System.out.println(it.next());
		
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		System.out.println("==================");
		for(Integer i : set) {
			System.out.println(i);
		}
	}
}
