package day14.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		
		/*
		 * [0-9]{2,4} 숫자중 2~4개 연속된 형태
		 * [0-9]{3} 숫자중 3개 연속된 형태
		 * [A-Z]+ 대문자 한 개이상
		 * [a-zA-Z]? 알파벳 0~1개 나오는 경우
		 * [가-힣]* 한글 0회 이상
		 * 정규 표현식에 속하지 않는 문자는 그냥 사용할 수 있다.
		 * [0-9]{3}-[0-9]{4} 숫자 3개 - 숫자 4개 나오는 형태
		 * 정규표현식에 포함되는 문자를 쓰고 싶다면 \\
		 * \\+  \가 1개 이상
		 * \?+ ?가 1개 이상
		 * 
		 * 정확히 일치하는 문자
		 * \?. 정확히 ?에 일치하는
		 * [0-9]{3}원  000원 형식을 찾음
		 * 
		 * \\d [0-9]와 같은 의미
		 * \\w [a-zA-Z_]와 같은 의미
		 * \\s 공백을 나타냄
		 * 
		 * 
		 */
		
		String info = "홍길동/주소/02-123-4567/aaa123@naver.com";
		String info2 = "이순신/주소/010-1234-1234/bbb123@gmail.com";
		
		//전화번호 형식
		String pattern = "\\d{2,3}-\\d{3,4}-\\d{4}";
		
		//이메일 형식(숫자문자@문자.문자)
		String pattern2 = "[a-zA-Z0-9]+@[a-z]+.[a-z]+";
		
//		String result1 = info.replaceAll(pattern, pattern2)
				
		//패턴을 컴파일
		Pattern p = Pattern.compile(pattern);
		Pattern p2 = Pattern.compile(pattern2);
		
		Matcher m = p.matcher(info);
		Matcher m2 = p2.matcher(info);
		
		//find) - 일치하는 부분이 있다면 true
		//start() - 일치하는 부분의 첫번재 인덱스
		//end() - 일치하는 부분의 마지막 인덱스
		//group() - 일치하는 부분의 추출
		
		while(m.find()) { //패턴이 여러번 나오면 순서대로 찾는다.
			
			System.out.println("첫번째 인덱스 : " + m.start());
			System.out.println("마지막 인덱스 : " + m.end());
			System.out.println(m.group());
		}
		
		while(m2.find()) { //패턴을 가장처음 발견되는 1번 찾습니다.
			System.out.println("첫번째 인덱스 : " + m2.start());
			System.out.println("마지막 인덱스 : " + m2.end());
			System.out.println(m2.group());
			
		}
		
		System.out.println("--------------------------------------------");
		List<String> list = Arrays.asList(info, info2);
		System.out.println(list.toString());
		
		//패턴생성	
		
		for (int i = 0; i < list.size(); i++) {//리스트에 있는 데이터를 String으로 넣고,
			//리스트 안에 요소들에서 순서대로 값을 찾는 형태
			String str = list.get(i);
			
			//패턴생성 // str을 분석해서 패턴을 생성해서,
			//Pattern x = Pattern.compile(pattern);
			//Pattern y = Pattern.compile(str);
			Matcher x = Pattern.compile(pattern).matcher(str);//1번째 패턴
			Matcher y = Pattern.compile(pattern2).matcher(str);//2번째 패턴
			
			if(x.find() && y.find()) { //
				
				System.out.println(x.group());
				System.out.println(y.group());
				
			}
		
		}
		
	}
}
