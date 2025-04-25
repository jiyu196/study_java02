package lesson15;

public class LambdaEx {
	public static void main(String[] args) {
		MyInter inter = (i) ->  i * i;//화살표있으면 람다식
			//i에 10넣었었음
		
		MyInter
			System.out.println(inter.la(10));
		
		return 0;
	}
			Object o2 = (MyInter) i -> i * i;
			Runnable runnable = () -> {};
			System.out.println("Runnable");
			

}
@FunctionalInterface   //함수적 인터페이스
interface MyInter {  //추상메서드가 반드시 1개
	int la(int i); //이게 추상메서드
}