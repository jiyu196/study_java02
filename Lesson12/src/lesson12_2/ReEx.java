package lesson12_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReEx {
	public static void main(String[] args) {
		String regex = "\\d"; //숫자
		regex = "[0-9]"; //숫자
		regex = "\\D"; //숫자아님
		regex = "[^0-9]"; //숫자아님
		Pattern p = Pattern.compile("b[A-Za-z]");  //"b[^A-Za-z]" =>소문자 알파벳, 문자
		//a부터z 까지 소문자범위. b다음에 영소가 오면 됨 
		//a-zA
		//* ->0개이상/+ -> 1개 이상. 저 안에 들어갈 패턴을 보는 것.
		//두개 이상은 2, 이런
		Matcher m;
		String[] strs = {"bat", "cat", "bed", "bAt", "Bat", "b", "ba"};
		
		//이메일 주소패턴
		//휴대전화번호 패턴
		
		for(String s : strs) {
			m = p.matcher(s);
			System.out.println(s+ "=" + m.matches());
		}
		String tel = "01[0-9]-[0-9]{3,4}-[0-9]{4}"; 
		//01[0-9] 01까지는 고정. 나머지 0은 0에서9사이/다음-[0-9]{3,4} 0에서9사이, 2개에서 4개 숫자
		String p1 = "010-1010-1111";
		System.out.println(p1.matches(tel));
		
		System.out.println("abcd1234abcd".replaceFirst("a", "e"));
		System.out.println("abcd1234abcd".replace("a", "e"));
		System.out.println("abcd1234abcd".replaceAll("a{1}", "e"));
		
//		System.out.println("bat = " + m.matches());
//		
//		m = p.matcher("cat");
//		System.out.println("cat = " + m.matches());
//		
//		m = p.matcher("bed");
//		System.out.println("bed = " + m.matches());
	}
}
