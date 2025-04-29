package lesson19;

import java.net.InetAddress;


public class InetAddressEx {
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("www.naver.com");  //inetaddress라는 객체만듦.  www는 서브 도메인
		System.out.println("호스트명 : " + ip.getHostName()); //호스트명 - 도메인 네임 (부르기 편한 형태)
		System.out.println("ip : "+ ip.getHostAddress());
		
		//ip전체
		InetAddress[] ips = InetAddress.getAllByName("www.naver.com");  //getallbyname  해당호스트에 있는 모든 ip를 배열로
		
		for(InetAddress i : ips) {
			System.out.println("ip주소: " + i);
		
		}
		byte[] ipAddr = ip.getAddress();  //byte 배열 음수값이 포함 될 수도 있어서 256을 더하라는 거
		for(byte b :ipAddr) {
			System.out.print((b < 0 ? b + 256 : b) + ".");
			
		}
		System.out.println();
		InetAddress local = InetAddress.getLocalHost();  //localhost에 있는 정보를 가져와라
		System.out.println("내 컴퓨터 ip: " + local);
		
		InetAddress ip2 = InetAddress.getByAddress(ips[0].getAddress());
		System.out.println(ips[0].getHostAddress() + "주소 : " + ip2);
		
//		System.out.println(InetAddress.getByAddress("));
	}
}
