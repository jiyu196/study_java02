package lesson18;

import java.io.FileOutputStream;

public class OutputStreamEx {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("output.txt", true); //true 쓰면 이어서 쓴다는 뜻. 13바이트가 하나 더 생긴거임
		fos.write('A');
		fos.write('B');
		fos.write('C');
		byte[] bs = {' ', 48, 49, 50, 51};
		fos.write(bs);
		
		fos.write(13);
		fos.write(10);
		fos.write(97);
		fos.write(98);
		fos.write(99);
		
		fos.close();
		
		//파일 이름은 output2.txt
		//A~Z의 문자들을 첫줄에 표현
		//a~z의 문자들을 둘째줄에 표현
		//각 개행 문자는 \n만 사용  64바이틑가 되면 됨.
		//반복문 써서
		
	}
}
