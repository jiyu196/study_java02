package lesson16;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMap {
	public static void main(String[] args) {
		//학생 타입의 List
		//List<Student> >> Stream<Student>
		//Stream<Student> >> Stream<Integer>
		
		List<Student> students = List.of(new Student("새똥이",100),new Student("개똥이",70),new Student("말똥이",80));
		Stream<Student> stream = students.stream(); //String으로 바꾸는 식. 이건 풀 ㅅ 있어야함
		IntStream stream2 = stream.mapToInt(s -> s.score); //integer 스트림
//		stream2.forEach(System.out::println);
		int sum= stream2.sum();
		
		System.out.println(sum);
	}
}

class Student {
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("Student [toString()=%s]", super.toString());
	}
	
	
	
}
