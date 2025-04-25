package lesson12_2;

import java.util.Calendar;
import static java.util.Calendar.*;

import java.text.SimpleDateFormat;

public class MyCalender {
	public static void main(String[] args) {
		//숫자 <> 문자열
		//숫자 >> 문자열 : format (형식화한다)
		//문자열 >> 숫자 : parse
		
		//날짜 <> 문자열
		//날짜 >> 문자열 : format
		//문자열 >> 날짜 : parse(널브러져있는 데이터를 한곳에 정형화시키는)
//		double d = 1e03;
		
		Calendar cal = getInstance();
		
		cal.set(DATE, 1);  //date값을 1로 지정을 해애 넣어서 가져옴 1일의 요일-2월임
		cal.add(MONTH, -1);
		
		int lastDate = cal.getActualMaximum(DATE);
		int startDay = cal.get(DAY_OF_WEEK);
		int d = startDay-1;
//		System.out.println(startDay-1); //startDay가 핵심단서. 
		System.out.println(new SimpleDateFormat("yyyy/MM 달력").format(cal.getTime()));
		for(int i =1-d; i <=lastDate; i++) {
			if(i < 1) {
				System.out.printf("%3c",' ');
			}
			else {
				System.out.printf("%3d",i);
			}
			
			if(i % 7 == ((7 - d) % 7)) {
				System.out.println();
			}
		}
	}
}
