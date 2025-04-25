package lesson15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsumerEx {
	public static void main(String[] args) {
		List<Integer> list = List.of(5,4,1,3,2);
		
		Consumer<Integer> con = o1 -> System.out.println(o1);
			
		
			
		list.forEach(o1 -> System.out.println(o1)); //for위치에서
		
		
		
		Map<String, Integer> map = new HashMap<String, Integer>(Map.of("A",10,"B",20));
				System.out.println(map.getClass().getName());
				
		map.forEach((k,v)->{
			
			System.out.println(k + ":" + v);
		});
		
		DoubleConsumer dc = d -> System.out.println(Math.round(d));
		dc.accept(10.5);  //consumer은 이름이 다 accept
		
		ObjDoubleConsumer<String> odc = (s, d) -> {};  //할일이 기억안나면 블럭 닫아놓기
		
		Supplier<String> supplier = ( ) -> "12345"; // 리터럴 명시 해줘야함. supplier.get하면 출력
		
		//1~100 List. 스트림 기법
		List<Integer> List2 =  IntStream.rangeClosed(1, 100).filter(i -> i%2 == 0).boxed().collect(Collectors.toList());
		System.out.println(List2);
		
		BiFunction<String, Integer, Boolean> bf = (s, i) -> s.equals(i+""); //equals써서 두개 문법이 같냐 물어보는. 스트링,인티져 맞춰주려고 쓴거임
		BiPredicate<String, Integer> bp = (s, i) -> s.equals(i+"");
		DoublePredicate dp = d -> d == 0; //doubleprdedicate는 더블이 앞에 있어서 제네릭 없음. 호출도 안함. 
		UnaryOperator<Integer> uo = i -> i; //파라미터도 인티져,반환도 인티져
	}

}
// consumer가 알고있는거 지우기