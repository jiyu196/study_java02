package lesson12;

import java.util.Arrays;

public class Ex250421{
	
		public static void main(String[] args) {
			
		//URI-식별자, URL(URI의 하위클래스)-식별자+위치이 있음
////			String[] url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EA%B3%A0%EC%96%91%EC%9D%B4&ackey=9f324k01".split("");
//			System.out.println(Arrays.toString(url));
			String  url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EA%B3%A0%EC%96%91%EC%9D%B4&ackey=9f324k01";
			// URIsearch.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EA%B3%A0%EC%96%91%EC%9D%B4&ackey=9f324k01
			
			
//			System.out.println(url.substring(url.indexOf("h"), url.lastIndexOf(":")));
//			System.out.println(url.substring(url.indexOf("search"), url.lastIndexOf("/")));
//			System.out.println(url.substring(url.indexOf("search.naver?"), url.lastIndexOf("?")));
//			System.out.println(url.substring(url.indexOf("where")));
//
//			System.out.println("===============================");
//			String arr = (url.substring(url.indexOf("search.naver?")));
//			System.out.println(arr);
//
//			String[] arr = (url.substring(url.indexOf("where"))).split("&");
//			for (int i = 1; i < arr.length; i++) {
//				System.out.println(i + "쌍 > " + arr[i]);
//			}
//
//			System.out.println("===============================");
//			String[] arr2 = (url.substring(url.indexOf("where"))).split("=");
//			String[] arr3 = (url.substring(url.indexOf("where"))).split("=");
//			String str = String.join("-", arr3);
//			System.out.println(str);
//			
//			for (int i = 1; i < arr2.length; i++) {
			////
//				System.out.println(i + "키 > " + arr2[i]);
			////
//				System.out.println(i + "값 >" + arr3[i]);
//			}
//		}
//
//}
//			String protocol = url.substring(0, url.indexOf("://"));
//			System.out.println(protocol);
//			url.substring(url.indexOf("://")+"://".length());  //<--------
//			
//			
//			String domain = url.substring(0, url.indexOf("/"));
//			System.out.println(domain);
//			url = url.substring(url.indexOf("/")+"/".length());  
//		
//			
//			String fileName = url.substring(0, url.indexOf("?"));
//			System.out.println(fileName);
//			url = url.substring(url.indexOf("?")+"?".length());  
//			
//			String queryString = url;
//			System.out.println(queryString);
//		}
			MyUrl myUrl = new MyUrl(url);
			System.out.println(myUrl);
		
		}
}
class MyUrl{
    String protocol;
    String domain;
    String fileName;
    String queryString;
    Param[] params;
    //key,value

    public MyUrl(String url) {
        protocol = url.substring(0, url.indexOf("://"));
        url = url.substring(url.indexOf("://") + "://".length());
        
        domain = url.substring(0, url.indexOf("/"));
        url = url.substring(url.indexOf("/") + "/".length());
        
        fileName = url.substring(0, url.indexOf("?"));
        url = url.substring(url.indexOf("?") + "?".length());
        
        queryString = url;
        String[] tmps = queryString.split("&");
        params = new Param[tmps.length];
        for(int i = 0; i < tmps.length; i++) {
//        	System.out.println(tmps[i]);
        	String[] t = tmps[i].split("=");
        	params[i] = new Param(t[0],t[1]);
        }

	}
    
	//code 자주 사용되는 기능 > 자동생성
	
    
	
	

	@Override
	public String toString() {
		return String.format("MyUrl [protocol=%s, domain=%s, fileName=%s, params=%s]", protocol, domain, fileName,
				Arrays.toString(params));
	}

	class Param {
		String key;
		String value;
		public Param(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		@Override
		public String toString() {
			return String.format("Param [key=%s, value=%s]", key, value);
		}
		
		
		
		
	}
		

		


//		
		
		// 프로토콜://도메인/파일명?쿼리스트링
		// 1. 위의 항목에 맞춰 문자열 자르기

		// where=nexearch & sm=top_hty & fbm=0 & ie=utf8 &
		// query=%EA%B3%A0%EC%96%91%EC%9D%B4 & ackey=9f324k01
		// 쿼리스트링은 키1=값1&키2=값2 잘라서 보여주기
		// 즉 값의 쌍은 &로 구분, 키와 값은 =로 구분
    
			
}