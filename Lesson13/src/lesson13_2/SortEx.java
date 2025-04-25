package lesson13_2;

import java.util.Set;
import java.util.TreeSet;

public class SortEx {
	public static void main(String[] args) {
		String str1 = "AAA"; //65에서
		String str2 = "AA"; //66을 뺌. 그래서 -1. 만약 C면 -2
		//숫자는 중요하지 않은데 양수냐 음수냐가 중요함. 두 숫자 사이에 부호가 뭐가나오느냐가 
		//AA, AB면 앞에는 공통이라 넘기고 뒤에를 비교해서 -1/ AA,Ac면 -2/ AA,AA는 동일 문자니까 0
		//AAA,AA면 문자가 A아니더라도 1이나옴./ AAAA,AA면 2가나옴. 근데 일단 부호가 중요하ㅣㅁ
		//문자여에도 comparable 인터페이스가 있다
		
		System.out.println(str1.compareTo(str2));
		
		Integer i = 10;
		System.out.println(Integer.compare(10, 20));
		
		Set<Data> set = new TreeSet<Data>();
		set.add(new Data(5, "A"));
		set.add(new Data(3, "A"));
		set.add(new Data(1, "A"));
		set.add(new Data(2, "A"));
		set.add(new Data(4, "A"));
		System.out.println(set);
	}
	
}

class Data implements Comparable<Data> {
	int i;
	String name;
	public Data(int i , String name) {
		this.i = i;
		this.name = name;
	
	}
	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		//return -(i - o.i);
//		return -Integer.compare(i, o.i);
		
		//i값을 기준으로 오름차순
		//i값이 서로 같을 시 name값 내림차순
		int ret = 0;
		ret = this.i - o.i;
		
		if(ret == 0) {
			return -this.name.compareTo(o.name);  //this붙여도 되고 생략해도됨.
		}
		return ret;
	}
	@Override
	public String toString() {
		return String.format("Data [i=%s, name=%s]", i, name);
	}
	
	
}
