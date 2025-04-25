package lesson13_2;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {   //set 중복불가
		Set<Integer> set = new TreeSet<Integer>();
		while(set.size() < 6) {  //set의 size(길이)가 6개보다 작을 때
			set.add((int)(Math.random()*45+1));
		}
		System.out.println(set);  //오름차순으로 정렬되서 나옴. 중복도 없음.
	}
}
