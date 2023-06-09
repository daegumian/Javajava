package day14.api.ramda.stream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass03 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();

		Random ran = new Random();

		for(int i = 0; i <100; i++) {
			list.add(ran.nextInt(100)+1); //1~100까지
		}
		System.out.print(list.toString()); //원본리스트, 천천히 메서드 적용해보기.
		System.out.println(); 
		
		//최종집계 함수
		//collect()
		
		List<Integer> newList = list.stream().sorted().filter( a -> a % 3==0).collect(Collectors.toList());
		System.out.println(newList.toString());//새로운 List배열로 생성
		
		Set<Integer> newSet = list.stream().sorted().filter( a -> a % 3==0).collect(Collectors.toSet());
		System.out.println(newSet.toString());//새로운 Set배열로 생성
		
		System.out.println("--------------------------------------");
		//sum(), count(), avg(), max(), min() - 숫자를 다루는 스트림에서만 사용.
		
		int r1 = list.stream().distinct().mapToInt(a->a).sum();
		System.out.println(r1);
		
		long r2 = list.stream().distinct().mapToInt(a -> a).count();
		System.out.println("개수 : " +r2);
		
		OptionalDouble r3 = list.stream().distinct().mapToDouble(a->a).average();
		System.out.println(r3);//옵셔널 더블형에서 더블값 반환//OptionalDouble[52.10606060606061]
		
		OptionalInt r4 = list.stream().distinct().mapToInt(a->a).max();
		System.out.println(r4);//OptionalInt[100]
		
		OptionalInt r5 = list.stream().distinct().mapToInt(a->a).min();
		System.out.println(r5);//OptionalInt[1]
		
		System.out.println("-------------------------------------------");
		
		
		//list에서 50보다 큰값만 중복 없이 저장하는 새로운 리스트를 생성 //매개값을 잘 모르겠다면 생성해서 보기.
		List<Integer> newList2 = list.stream().distinct()
											  .filter( a -> a > 50)
											  .sorted()
											  .collect(Collectors.toList());
		System.out.println("중복없이, 50보다 큰값들? : " + newList2.toString());
		
		//Stream<Integer> stream = list.stream();//중간처리 후 다시 stream으로 반환! -> 중복 처리 가능!
		//함수적 프로그램이라고 함.
		System.out.println("---------------------------------------------");
		
		IntStream.range(1, 10).forEach( a -> System.out.print(a) );//미만까지 정수 스트림 반환
		System.out.println();//123456789
		IntStream.rangeClosed(1, 10).forEach( a -> System.out.print(a) );//포함 정수 스트림 반환
		System.out.println();//12345678910
		
		int result2 = IntStream.range(1, 100).sum();
		System.out.println(result2);//4950
		
		//정수 스트림 -> 일반스트림 형변환 방법 
		Stream<Integer> stream = IntStream.rangeClosed(1, 100).boxed();
		
	}
}
