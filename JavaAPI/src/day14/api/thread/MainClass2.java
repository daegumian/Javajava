package day14.api.thread;

public class MainClass2 {
	
	public static void main(String[] args) {
		
		//쓰레드를 상속받은 클래스는 직접 사용
		ThreadTest2 thread = new ThreadTest2();
		thread.setName("Thread_B");
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
	
		}
		
		System.out.println("메인쓰레드 종료");
	}

}
