package day14.api.ramda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class MainClass2 {

	public static void main(String[] args) {

		/*
		 * 람다 함수의 구현 사용문법
		 * Predicate - 매개변수가 하나 있고, boolean형 반환
		 * Consumer - 매개변수 하나 받고, void형 메서드 (forEach)
		 * Function - 매개변수 여러개 받고, 반환은 1개
		 */
		List<Integer> list = new ArrayList<>();

		Random ran = new Random();

		for(int i = 0; i <100; i++) {
			list.add(ran.nextInt(100)+1); //1~100까지
		}
		System.out.println(list.toString()); //원본리스트, 천천히 메서드 적용해보기.
		//[24, 14, 16, 22, 10, 55, 53~~~12]

		//중간처리 함수들
		//distinct() - 중복제거
		//Stream<Integer> stream = list.stream();
		//stream = stream.distinct();//중복 제거
		//stream.forEach( (a) -> System.out.print(a + " ") );

		list.stream().distinct().forEach((a) -> System.out.print(a + " "));
		System.out.println();//24 14 16 22 10 55 53 28 76 3...

		System.out.println("=--------------------------=");

		//sort() 정렬
		list.stream().sorted().forEach((a) -> System.out.print(a + " "));
		//정렬되어서 출력.
		System.out.println("--------------------");
		
		//filter() - 리턴에 true값만 남기고 필터링 = 짝수만 리턴하겠다. ***유용***
		//list.stream().distinct().filter((a) -> {return true;});
		list.stream().distinct().filter((a) -> a%2==0).sorted().forEach( a -> System.out.print(a));
		//2 8 10 14 16 20 22 2...
		System.out.println("\n---------------------------------");
		
		//map() - 반환에 정의된 값으로 완전히 새로운 스트림반환 ***유용***
		list.stream().map( (a) -> a %2 ==0? "짝수" : "홀수").forEach(a->System.out.print(a + " "));
		//짝수 짝수 짝수 짝수 짝수 홀수 홀수 짝수 짝수 홀수...
		System.out.println("\n---------------------------------");
		
		//mapToDouble() - 반환에 정의된 값으로 double형 스트림 변경
		//mapToInt() - 반환에 정의된 값으로 int형 스트림 변경
		//mapToLong() - 반환에 정의된 값으로 long형 스트림 변경
		list.stream().mapToDouble( a -> a).forEach(a -> System.out.print(a + " "));
		//24.0 14.0 16.0 22.0...
	}
}
