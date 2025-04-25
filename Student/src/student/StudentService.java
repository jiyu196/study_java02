package student;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StudentService implements Comparable<Student>{
	// 1. 학생 예제의 배열 > 리스트로 교체
	// 2. 이름 유효성을 정규표현식으로 교체

	// 가져오는거 getter, 받는거 setter
	// try ,catch 예외처리 사용하기.
	// main에 try catch.

	private List<Student> students = new ArrayList<Student>();
	private List<Student> sortedStudents;  ////sortedStudents.addAll(students); 이거하면 addAll 할 수 있는

	// 등록 학생수 count  사용 안함

	{
//		students.add(new Student(1, "개똥이", randomScore(), randomScore(), randomScore())); //학생 인스턴스를 strudents에 입력합자
		students.add(Student.builder().no(1).name("개똥이).kor(randomScore()).eng(randomScore()).mat(randomScore()).build();
//		students.add(new Student(2, "새똥이", randomScore(), randomScore(), randomScore()));
//		students.add(new Student(3, "말똥이", randomScore(), randomScore(), randomScore()));
//		students.add(new Student(4, "소똥이", randomScore(), randomScore(), randomScore()));

		sortedStudents = new ArrayList<Student>(students);  //다른방법으로는 생성자 사용
		//sortedStudents = students.clone();  // sortedStudents에 모든 students를 넣어라
		// 정렬만 수행하는거, 조회만 수행하는거 따로할거임 Arrays.copyOf(students, students.length)원래 이거했는데
		// 대신clone집어넣음. clone한 이유는 서로 다른거라는걸 나타내려고. 들어있는 값은 유지하되 다른 공간
		//List는 인터페이스라서 clone할 수 없음
		//sortedStudents.addAll(students);  addAll은 다른 리스트를 추가하는거
		rank(); // 클론은 지원하지 않아서 다른 표현을 생각해야함
	}
	private StudentService studentService = new StudentService();
	private StudentService() {
	
	}
	public static StudentService getInstance(); {
		return studentService; 
	}
	
	public int randomScore() {

		return (int) (Math.random() * 41 + 60);
	}

	// 입력: 학번
	// 출력: 학생
	Student findBy(int no) {
		Student student = null; // 0값 부여하는것처럼
		for (int i = 0; i < students.size(); i++) {
//			System.out.println(students.get(i));
			if (students.get(i).getNo() == no) { // The field Student.no is not visible이 오류는 메서드를 통해서
				student = students.get(i);
				break;
			}
			
		}
		return student;
	}

	public int checkRange(String subject, int input, int start, int end) {
		if (input < start || input > end) {
			throw new IllegalArgumentException(subject + "값의 범위가 벗어났습니다." + start + "~" + end + "사이의 입력을 해주세요");

		}
		return input;
	}

	public int checkRange(String subject, int input) {
		return checkRange(subject, input, 0, 100);
	}

	public String inputName() {
		String name = StudentUtils.nextLine("이름 > ");   
		if(!name.matches("[가-힣]{2,4}")) {
			throw new IllegalArgumentException("이름은 2~4글자의 한글입니다.");
		}
		return name;
//		Pattern p = Pattern.compile("^[가-힣]{2,4}");  //{2,4}=>뜻이 2개부터 4개의 문자.?암튼 ~부터라는 거
//		//"[^가-힣]{2,4}" =>이렇게 되면 문자가 아니다가 됨.가-힣은 아니고 2에서4일때만
//		Matcher m;
//		m = p.matcher(name);
//		
//		for(int i = 0; i < name.length(); i++) {
//		if(!(m.matches())) {  //만약 정규 표현식그게 틀리다면 다시 입력
//			System.out.println("2~4 사이의 한글로 입력해주세요");
//		}
//	}
//		if(name.length() < 2 || name.length() > 4) {
//			throw new IllegalArgumentException("이름은 2~4글자로 입력하세요");
//		}
//		for(int i = 0; i < name.length(); i++) {
//			if(name.charAt(i) < '가' || name.charAt(i) > '힣');
//				throw new IllegalArgumentException("이름은 한글로 구성되어야합니다.");
//	}   
//	return name;
	
	}

	// 등록
	public void register() {
		System.out.println("등록 기능");
		// 학생 생성
		// 학번, 이름, 국어, 영어, 수학
		
		int no = StudentUtils.nextInt("학번 > ");
		
		Student s = findBy(no);
		
		if(s != null) {
			System.out.println("중복된 학번이 존재합니다.");
			return;
		}
		
		
		String name = StudentUtils.nextLine("이름 > ");   
//		student findBy(name);
//		
		
		int kor = StudentUtils.nextInt("국어 > ");
		checkRange("국어", kor);
		
		int eng = StudentUtils.nextInt("영어 > ");      //여기서 예외 발생하면  main으로 넘김
		checkRange("영어", eng);
		
		int mat = StudentUtils.nextInt("수학 > ");      
		checkRange("수학", mat);
			
		Student s2 = new Student(no, name, kor, eng, mat); //sorted에도 같은 학생이 되야하는데 
		//그냥넣으면 같은 주소로가아니라 다르게 인식해서 s2만들어서 넣기
		students.add(new Student(no, name, kor, eng, mat));
		sortedStudents.add(s2); //정렬만 수행하는거, 조회만 수행하는거 따로할거임
		rank();
}

	// 조회
	public void read() {
		System.out.println("조회 기능");

		print(students);
//		for(int i = 0 ; i < count ; i++) {
//			System.out.println(students[i].no + ", " + students[i].name + ", " + students[i].total() + ", " + students[i].avg());
	}

	public void readOrder() {
		System.out.println("석차순 조회 기능");
		print(sortedStudents);
	}

//		public String toString() {
//			return getClass().getSimpleName() + "[" + read + "]";
//		}
	public void print(List<Student> stu) {
		for (int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i));
		//	stu.forEach(s -> System.out.println(s));  이건 위에꺼 한줄로 끝나는
		}
	}

	// 수정
	public void modify() {
		System.out.println("수정 기능");
		// 학생들 배열에서 입력받은 학번과 일치하는 학생
		int no = StudentUtils.nextInt("수정할 학생의 학번 > ");
		Student s = findBy(no);
		if (s == null) {
			System.out.println("입력된 학번이 존재하지 않습니다.");
			return;
		}
		String name = inputName();
		s.setName(StudentUtils.nextLine("이름 > "));
		s.setKor(StudentUtils.nextInt("국어 > "));
		s.setEng(StudentUtils.nextInt("영어 > "));
		s.setMat(StudentUtils.nextInt("수학 > "));
//		sortedStudents = Arrays.copyOf(students, students.size()); 존재할 필요 없음
		rank();

	}

	// 삭제
	public void remove() {
		System.out.println("삭제 기능");
		int no = StudentUtils.nextInt("삭제할 학생의 학번 > ");
		Student s = findBy(no);  //주소갖고온
		if (s == null) {
			System.out.println("입력된 학번이 존재하지 않습니다.");
			return;
		}

		students.remove(s); //학생을 지워라
		sortedStudents.remove(s);  //arrays.copyof이건 땡겨올려고 쓴거. 
		//rank(); //석차 재조정이 필요하기 때문에 지우기
	}

	// 과목별 평균
	public void allAvg() {
		// 국어, 영어, 수학, 전체평균
	//	students.stream().map(s->s.getKor());  //인티저 스트림
		
		double avgKor = 0;
		double avgEng = 0;
		double avgMat = 0;
		double avgAll = 0;

		// count 몇명의 학생을 기준으로 현재 평균이 얼마이다
		//int size = students.size();  //이렇게 변수로 만들어놓으면 밑에 적은거 students.size이걸 size만 적어도 됨.줄여야하는 상황에서 줄이는거
		for (int i = 0; i < students.size(); i++) {
			avgKor += students.get(i).getKor();
			avgEng += students.get(i).getEng();
			avgMat += students.get(i).getMat();
		}
		avgKor /= (double) students.size();
		avgEng /= (double) students.size(); // 반복된게 많음. 같은 라인보이면 메서드쓰거나 반복문 사용해서 줄이기
		avgMat /= (double) students.size();

		avgAll = (avgKor + avgEng + avgMat) / 3;

		System.out.println(students.size() + "명의 학생 평균");
		System.out.println("국어 평균" + avgKor);
		System.out.println("영어 평균" + avgEng);
		System.out.println("수학 평균" + avgMat);
		System.out.println("전체 평균" + avgAll);
	}
	



	// 석차
	public void rank() {  //학생들에대한것도 들어가야하기 때문에 integer로만은 안됨
    //1. List.sort()  comparator인스턴스를 정의한다
	//2. TreeSet() 이름순
		sortedStudents = new ArrayList<Student>()
	//3. Collections
//		Collections.sort(sortedStudents, (o1, 02) ->.total() - o1.total()); //comparable있어야함
//		sortedStudents.sort(new Comparator<T>() {
//			
//			
//		
//			
//			@Override
//			public int compare(Object o1, Object o2) {
//				// TODO Auto-generated method stub
//				
//				return 0;
//				
//		});
		
//		sortedStudents = new ArrayList<>()
//		Set<Integer> set = new TreeSet<>();
//		set.add(sortedStudents.size());
//		System.out.println(set);
////		
////		Set<Integer> set = new TreeSet<Integer>();
////		while(sortedStudents.size()==students) {
////			
////		}
//		System.out.println(set);
////		Set<Addr> set2 = new TreeSet<>();
////		set2.add(new Addr(sortedStudents.size(),students));
	
//		
//
	}
		
	

}