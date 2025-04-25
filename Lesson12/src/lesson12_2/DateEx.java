package lesson12_2;

import java.util.Date;
import java.text.SimpleDateFormat;

//1.0
//1.1
//1.2
//1.7
@Deprecated  //--밑줄 그어져있는거. 쓰지 말라는 뜻
public class DateEx {
	public static void main(String[] args) {
		Date now = new Date();	
		System.out.println(now.toString());
		System.out.println(now.toLocaleString()); //tolocalString이거 한국 형식에 맞춰서 나온
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a"); //mm소문자로 쓰면 분. H는 24시간. 1시는13시로 나옴
		System.out.println(sf.format(now));
				
		
	}	
}

