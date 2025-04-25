package lesson16_2;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	public static void main(String[] args) {
		
	
	//1. 스트림 생성방법
    //of(), builder(), generate(), 배열로부터, 컬렉션으로 부터
	
	//2. 스트림의 종류
	//Stream<T> , InStream, DoubleStream, LogStream
	
	//3. 스트림의 연산
	//최종연산
	//forEach()
	//중간연산
	//filter(), distinct(), map(), flatMap(), sorted(), peek()
	
	List<Integer> list = IntStream.range(1, 10).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(list);
	//boxed 쓰면 Integer 이 됨. 
	//sorted-compare같이 .오름차순. 내림으로 하고싶으면()->{} 이건가
	//sorted 안ㅇㅔ Integer::compare-> 오름차순,  Comparator.reverseOrder() -> 내림차순. 
	
	 List<Integer> list2 = new Random().ints(10, 0,10).boxed().peek(System.out::println).collect(Collectors.toList());
	 System.out.println(list2);  //peek 중간연산. 숫자 하나하나를 뽑라내는
	 
	 boolean result = Stream.of(1,3,5,8).allMatch(i -> i%2==1);
	 System.out.println(result);
	 
	 result = Stream.of(1,3,5,8).anyMatch(i -> i%2==1);
	 System.out.println(result);
	 
	 result = Stream.of(0,2,4,3).noneMatch(i -> i%2==1);
	 System.out.println(result);
	}
}
