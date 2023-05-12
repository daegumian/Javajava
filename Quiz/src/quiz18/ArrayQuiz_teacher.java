package quiz18;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQuiz_teacher {

	public static void main(String[] args) {

		//arr과 arr2는 길이가 1차이가 난다.
		//arr은 마라톤 참가자이다
		//arr2는 마라톤 완주자이다
		//완주하지 못한 사람을 리턴하는 메서드를 만드세요.
		
		String[] arr = {"홍길동", "홍길자", "이순신", "신사임당"};
		String[] arr2 = {"홍길동", "이순신","신사임당"};
		
		System.out.println(test(arr, arr2));
	}
	
	public static String test(String[] arr, String[] arr2) {
		
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		for(int i = 0; i < arr2.length; i++) {
			if(!arr[i].equals(arr2[i])) { //문자열 비교는 .equals ->equals()가 아니면이면, 제일 앞에 !를 붙인다.
				return arr[i];
			}
		}
		return arr[arr.length-1]; 
	}
}
