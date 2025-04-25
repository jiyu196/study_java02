package lesson16;

public class StackOverFlowTest {
	public static void main(String[] args) throws Exception {
//		main(args);
//		new Data();
//		new Data();
//		Class.forName("leson16.Data");
		Data.print(10); //메로리가 코드에 로드한다.
		Data.print(10); //메로리가 코드에 로드한다.
		Data.print(10); //메로리가 코드에 로드한다.
		Data.print(10); //메로리가 코드에 로드한다.
		Data.print(10); //메로리가 코드에 로드한다.
		//클래스가 메모리에 로드할때
	}
}
class Data {  //class자체는 메모리에 로드될 때 클래스 변수에 대한 로드가 끝남
	//초기화가 다 끝나있어야
//	Data data = new Data();
	int i = print(1);
	static int si = print(2);  //static은 최초에 한번만.그 외에는 실행이 될 때 되는거  
	{
		System.out.println("초기화 블럭");
	}
	static {
		System.out.println("클래스 초기화 블럭");
	}
	public Data() {
		System.out.println("생성자");
	}
	static int print(int i) {
		System.out.println("print호출됨 ::" + i);
		return i;
	}
}
