package day14.api.thread;

public class ThreadTest2 extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			System.out.println("쓰레드를 상속받은 클래스 : " + i);
			System.out.println("쓰레드의 이름 : " + getName());

			try {
				sleep(1000);//상속받아서 그냥 sleep 쓸 수 있음.
			} catch (Exception e) {
			}
		}
	}





}
