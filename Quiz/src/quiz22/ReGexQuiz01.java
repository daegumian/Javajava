package quiz22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReGexQuiz01 {
	public static void main(String[] args) {
	
		/*
		 * 가격 형식은 전부 찾아서 순서대로 출력 해보기
		 * 패턴은 1개면 된다.
		 * 
		 */
		
		String str = "안녕하세요? 점심은 4,500원 인데요. 커피가 무려 1600원 이에요. 디저트는 무려 14000원 이나 한답니다";
		
		String pattern = "[0-9,]+원";
		
		Matcher m = Pattern.compile(pattern).matcher(str);
		
		while(m.find()) { //if문으로 하면 맨 처음 하나만 찾음
			System.out.println(m.group());
		}
	
	
	}

}
