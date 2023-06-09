package quiz22;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReGexQuiz02 {

	public static void main(String[] args) {

		String str = "123123-1231231 GS25(치킨마요) 4,400원";
		String str2 = "123123-1231232 GS25(주부18단) 5,000원";

		String pattern1 = "[0-9-]{6,7}[0-9]{6,7}";
		//String pattern1 = "\\d{6}-\\d{7}";
		String pattern2 = "[A-Z]+[0-9]+";
		//String pattern2 = "[A-Za-z]+25";//GS25
		String pattern3 = "[(가-힣(18)]{2,10}"; //내식
		//String pattern3 = "\\(+[가-힝0-9]*\\)"; //마산식
		//String pattern3 = "\\([가-힣0-9]+\\)" //선생님식
		String pattern4 = "[0-9,]+원"; // \\d+, \\d+원

		List<String> list = Arrays.asList(str, str2); //리스트 생성하기
		System.out.println(list.size()); //길이는 2

		for (int i = 0; i < list.size(); i++) { //첫번째 인덱스 데이터부터 비교
			
			String a = list.get(i);
			
			Matcher x = Pattern.compile(pattern1).matcher(a);//1번째 패턴
			Matcher y = Pattern.compile(pattern2).matcher(a);//2번째 패턴
			Matcher z = Pattern.compile(pattern3).matcher(a);//3번째 패턴
			Matcher k = Pattern.compile(pattern4).matcher(a);//4번째 패턴
			
			if(x.find()&&y.find()&&z.find()&&k.find()) {
				
				System.out.println("----------------------");
				System.out.println(x.group());
				System.out.println(y.group());
				System.out.println(z.group());
				System.out.println(k.group());
			}
		}
		
//		for(String s : list) { //선생님 방법
//			
//			Matcher m1 = Pattern.compile(pattern1).matcher(s);
//			Matcher m2 = Pattern.compile(pattern2).matcher(s);
//			Matcher m3 = Pattern.compile(pattern3).matcher(s);
//			Matcher m4 = Pattern.compile(pattern4).matcher(s);
//			
//			if(m1.find() && m2.find() && m3.find() && m4.find()){
//				
//				System.out.println("----------------------");
//				System.out.println(m1.group());
//				System.out.println(m2.group());
//				System.out.println(m3.group());
//				System.out.println(m4.group());
//			}
//			
//		}		
		
	}
}
