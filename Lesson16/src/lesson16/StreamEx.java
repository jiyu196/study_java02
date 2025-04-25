package lesson16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	public static void main(String[] args) {
		Stream<Integer> stream =  Stream.of(10,30,40,20,20,30);
		stream.forEach(i-> System.out.println(i)); //내부 반복자가. 지금 이건 stream을 소비했다고 함
//		stream.forEach(i-> System.out.println(i)); //다시 쓰고싶으면 재생성해야함
		stream = Stream.of(10,30,40,20,20,30); //stream 재생성,
		stream.forEach(i-> System.out.println(i));
		
		int[] arr = {1,2,3,4,5};
		IntStream is = Arrays.stream(arr);
		
		List<String> list = List.of("새똥이", "개똥이");
		Stream<String> stream2 =  list.stream(); //스트림화 되는거.
		System.out.println("===========================");
		
		stream2.forEach(s->System.out.println(s));
		
		Stream<Object> stream3 = Stream 
		.builder()
		.add("가")
		.add("나")
		.add("다")
		.build();
		
		System.out.println("===========================");
		stream3.forEach(s->System.out.println(s));
		
		Stream<String> stream4 = Stream.generate(()-> "abcd").limit(10); //abcd 10개가 들어간 코드생성
		
		System.out.println("===========================");
		stream4.forEach(s->System.out.println(s));
		Stream<Integer> stream5 = Stream.iterate(1,i-> i+1).limit(10);
		
		System.out.println("===========================");
		stream5.forEach(s->System.out.println(s));
	}
}