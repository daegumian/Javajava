package day12.api.lang.system;

import java.util.Iterator;

public class MainClass {

	
	public static void main(String[] args) {
		
		//System클래스는 전부 static메서드로 선언되어 있다. 점찍어서 사용
		
		//System.exit(0); - 시스템 종료
		
		//1970년 1월 1일 ~~현재까지 시간을 밀리초 반환
		//간단한 프로그램 시간체크
		
		long start = System.currentTimeMillis();
		
		long sum = 0;
		for(long i = 0; i < 1000000; i++) {
			sum += i;
//			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)*0.001);
		
		
	}
}
