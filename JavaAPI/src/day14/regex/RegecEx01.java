package day14.regex;

public class RegecEx01 {

	public static void main(String[] args) {
		
		String info = "홍길동|30세|서울시 강남구 |010-1234-5678";
		
		//전화번호형식을 찾아서 ***-****-**** 해주세요.
		
		String pattern = "[0-9]{3}-[0-9]{4}-[0-9]{4}";
		
		//info.replaceAll(정규표현식, 치환될 문자)
		
		//특정 API에서 regex가 있다면, 정규표현식을 적용할 수 있다는 의미!
		String result = info.replaceAll(pattern, "***-****-****");
		System.out.println(result);
		
		String pattern2 = "[0-9]{2}세";
		String result2 = info.replaceAll(pattern2, "비밀");
		System.out.println(result2);
		
	}
}
