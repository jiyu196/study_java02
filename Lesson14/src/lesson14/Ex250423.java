package lesson14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class Ex250423 {
	public static void main(String[] args) {
		//1. 학생 예제 내의 정렬을 List의 sort로 구현, Comparator 사용
		
		//2. Map을 사용한 문자의 빈도 계산-map의 key를 이용해서 해야함
		//문자열이나 문자배열, 문자열 배열 사용해서 하는데 문자열배열이 제일 쉬움
		
		
		String str = "aaaaabbbbcccddddd";
		Map<String, Integer> map = new HashMap<>();
		
		String[] strs = str.split("" ); //문자열생성
		
		for(String s:strs) {
			System.out.println(s);  //문자열 추출
			Integer i = map.get(s); //반환값은 Integer. get은 key를 통해서 값을 가져옴. value를 가져오는데 그게 Integer.그렇기 때문에 null값쓸 수 있는거
			map.put(s, 1);  //아직 아무것도 없어서 null값
//			if(i == null) { //없으면 넣어준다. 1을
//			}
//			else {
//				map.put(s, i+1); //null값이 아니면 +1을 해준다
//			}
			map.put(s,i == null ? 1 : i + 1);
			System.out.println(map);
		}
		
//		Stram이용해서하는
//		Stream.of(strs).forEach(s->{
//			Integer i = map.get(s);
//			map.put(s, i == null ? 1 : i + 1);
//			
//		});
//		System.out.println(map);

		
		
	}
}
