package lesson17;

public class ProcessEx {
	public static void main(String[] args) throws Exception{
		Process p1 = Runtime.getRuntime().exec("notepad.exe");
		Process p2 = Runtime.getRuntime().exec("mspaint.exe");
		p1.waitFor();
		p2.destroy();
		//노트 먼저 닫으면 다 꺼짐. 노트부터 순서대로 적었기때문에 순서대로 실행되서 
	}
}
