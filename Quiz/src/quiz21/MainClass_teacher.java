package quiz21;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass_teacher {

	private static final int Predicate = 0;

	public static void main(String[] args) {

		//지역명, 규모구분, 연도, 월, 분양가격 -> 1행 4800개
		/*
		 * 1.버퍼리더 이용햇 한줄씩 읽습니다.
		 * 2.split(",", 5)를 사용해서 Data객체에 한줄 단위로 저장을 하고
		 * 3.List<Data>에 하나씩 추가를 합니다.
		 * 
		 * 4.람다식 이용해서 (지역:서울, 4분기중 9~12월, 분양 가격: 2000이상)인 객체만 뽑아서 
		 * 새로운 리스트로 반환. -> toList.
		 */
		
		List<Data> list = new ArrayList<>(); //저장할 리스트

		String path  = "C:\\Users\\user\\Documents\\카카오톡 받은 파일\\주택도시보증공사_전국 평균 분양가격.csv";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "EUC-KR")))
		{ // 한글 깨지는 것 찾기. 관문 1
			br.readLine();//분양가격 없애려고
			String str;
			while((str = br.readLine()) != null) {
				
				String[] arr = str.split(",", 5); //split은 배열로 변환해줌

				String region = arr[0];
				String size = arr[1];
				String year = arr[2];
				String month = arr[3];
				String price = arr[4].replace(" ", "").replace(",", "").replace("\"", "").replace("-", ""); //쌍따옴표는 \"
				
				price = price.equals("") ? "0" : price; //공백이라면, "0" 대입 그대로
				
				System.out.println(Integer.parseInt(price));
				
				Data data = new Data(region, size, year, month, price);
				list.add(data);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//4번에 대한 처리.. 숙제




	}

}
