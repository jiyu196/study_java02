package lesson16_2;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class AggrEx {
	public static void main(String[] args) {
		//갯수, 합계, 평균, 최대, 최소
		List<Student> list = List.of(new Student("새똥이",100), new Student("개똥이",90), new Student("말똥이",70));
		
		long count = list.stream().filter(s->s.score >=80).count(); //s 학생-> s.score 학생의 점수가 80이상면
		System.out.println(count); //count는 반환값이 long
		
		int sum = list.stream().mapToInt(s -> s.score).sum(); //학생들 점수의 총합. 기본 스트림타입으로 바꾼거.
		System.out.println(sum);
		
		OptionalDouble od = list.stream().mapToInt(s -> s.score).average(); //학생들 점수의 총합. 기본 스트림타입으로 바꾼거.
		System.out.println(od.getAsDouble()); //값만 나오게 하려면 .get인데 double이라 getasdouble로
		
		Optional<Student> optional = list.stream().max((s1,s2)-> s1.name.compareTo(s2.name));
		System.out.println(optional);
		
		long min = list.stream().mapToLong(s -> s.score).min().getAsLong();
		System.out.println(min);
		
		Stream.concat(null, null); //두개 stream을 붙이는거
		"abcd".concat("1234");
	} 
	
}

