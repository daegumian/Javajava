package quiz21;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {



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

		String cvs = "C:\\Users\\user\\Documents\\카카오톡 받은 파일\\주택도시보증공사_전국 평균 분양가격.csv";

		List<Data> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cvs), "EUC-KR")))
		{
			String re;
			String[] dataArr;
			Data data;
			br.readLine();
			while((re = br.readLine()) != null) {

				dataArr = re.split(",", 5);

				data = new Data(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4]);
				list.add(data);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Data> newList = list.stream().filter( a -> a.getRegion().equals("서울"))
				.filter(a -> Integer.parseInt(a.getMonth()) >= 9 && Integer.parseInt(a.getMonth()) <= 12)
				.filter(a -> Integer.parseInt(a.getPrice()) >= 2000).collect(Collectors.toList());

		newList.stream().forEach(a->System.out.println(a.toString()));
		
	}

}
