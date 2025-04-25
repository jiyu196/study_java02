package lesson16_2;

import java.util.Optional;

public class OptionalEx {
	public static void main(String[] args) {
		Optional<Integer> optional = Optional.ofNullable(null);  //아이템을 딱 하나만 넣은 수 있는
		
//		if(optional.isPresent())
//		{
//			System.out.println(optional.get());   ===>이게 ifPresent, orElseThrow쓰기전 썼던 식
//		}
//		else {
//			System.out.println(50);
//		}
		
		
		System.out.println(optional.orElse(20)); //원래Optional[10]이렇게 나오는데 .get붙이면 박스안에 있는 값만 나옴
		//.orElse 넣으면 대체값
		System.out.println(optional.orElseGet(()->30));  //()->{} 이게 서플라이어.?였나
		
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());
		
		optional.ifPresent(System.out::println);  
		//존재한다면 할일 정하는.null이면 안나오고 값이 들어가 있으면 그 값이나옴
		
		optional.orElseThrow(()-> new RuntimeException("값이 없음")); //오류창에 빨간 글씨로 값이 없음 뜸.
	}
}
