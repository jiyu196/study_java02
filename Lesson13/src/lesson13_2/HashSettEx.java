package lesson13_2;

import java.util.HashSet;
import java.util.Set;

public class HashSettEx {  // 단축키 art누르면 단축키 
	public static void main(String[] args) {
		Set<Addr> set = new HashSet<>();  //set을 제네릭(<>)으로 만들. 의미상 같기때문에 <>뒤에는 생략해도됨.
		//HashSet<Addr> set = new HashSet<Addr>();  
		set.add(new Addr("새똥이", "1234"));
		System.out.println(set);
		Addr addr = new Addr("개똥이", "5678");
		set.add(addr);
		set.add(addr);  //하나 더 늘린다고해서 개수가 늘어나지 않음
		System.out.println(set);
		
		//boolean 타입 => equals(), int타입=> hashcode()
		Addr addr2 = new Addr("말똥이", "1234");
		set.add(addr2);
		System.out.println(set);
		
		for(Addr a : set) {
			System.out.println(a.hashCode());
		}
		System.out.println(addr2.hashCode());  //의도적으로 중복 만든거
		System.out.println("1234".hashCode());  //의도적으로 중복 만든거
	}
}
class Addr implements Comparable<Addr> {  //implements(구현하다) 써야함
	String name;
	String tel;  //문자열 생성
	public Addr(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
		
	}
	@Override
	public String toString() {
		return String.format("Addr [name=%s, tel=%s]", name, tel);
	}
	@Override
	public int hashCode() { //파라미터 없음. 누구의 주소로 보여줄건지 모르기때문에 해시가져와야함
		// TODO Auto-generated method stub
		return tel.hashCode();
	}
	@Override
	public boolean equals(Object obj) {  //파라미터로 전달받은 객체
		return tel.equals(((Addr)obj).tel);  //addr로 형변환을 해줘야 .string의 equals로 앞tel과 뒤tel 비교
	}
	@Override
	public int compareTo(Addr o) {  //만약 object로 했으면 위에 equals처럼 형변환 해줬어야해서 Addr로 함.
		
		return -name.compareTo(o.name);
	}
	
	
}
