package lesson17;

public class ThreadEx {
	public static void main(String[] args) {
		System.out.println("main 시작");
		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		myThread1.start();  //멀티 스레드는 호출 스택이 2개 이상. 모든 스택이 다 없어야 끝나는
		myThread2.start();
		Thread thread = new Thread(new MyRunable());
		Thread thread2 = new Thread(() -> {
			for(int i = 0; i < 50; i++) {
				System.out.println(i+ ":: Thread :: "+ Thread.currentThread().getName());
			}
		});
//		myThread.run();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main 종료");
		
	}
}
class MyThread extends Thread {

	
	@Override
	public void run() {
//		test();
		for(int i = 0; i < 50; i++) {
			System.out.println(i+ ":: Thread :: "+ getName());
		}
	
	}
	void test() {
		System.out.println("test");
	}
	
}
//class MyRunable implements Runnable {
//
//	@Override
//	public void run() {
//		for(int i = 0; i < 50; i++) {
//			System.out.println(i+ ":: Thread :: "+ getName());
//		}
//	}
//
//}
class MyRunable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println(i + " :: Thread :: " + Thread.currentThread().getName());
		}
	}
}