package quiz22;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReGexQuiz03_teacher {

	private static final int ArrayList = 0;

	public static void main(String[] args) {

		/*
		 * 1. 버퍼리더를 사용해서 건담.txt를 읽어들인다.(readLin으로 한 줄씩 읽어들임)
		 * 2. 정규표현식을 이용해서 날짜, 지점, 등급, 내용, 가격 을 정규표현식으로 패턴분석
		 * 	  Product 객체에 저장하고, 리스트에 저장
		 * 
		 * 3. 외부라이브러리 (POI) - 자바에서 엑셀파일 xlsx 형태로 파일을 쓸 수 있도록하는 기능
		 * 	  하나에 시트에 각 행데이터를 엑셀 파일로 출력.
		 * 
		 * 	private String day;
	private String store;
	private String grade;
	private String detail;
	private String price;
		 */


		List<Product> list = new ArrayList<>();

		String path = "C:\\Users\\user\\Documents\\카카오톡 받은 파일\\건담.txt";

		try (BufferedReader br = new BufferedReader((new FileReader((path))))){

			String str;
			while((str = br.readLine()) != null){

				String pattern1 = "[0-9]{8}-[0-9]{2}-[0-9]{12,13}";
				String pattern2 = "[가-힝]+ [가-힝]+점";//[가-힝]+ (강남점|평내호평점|인천점...)
				String pattern3 = "\\[[가-힣A-Z]+\\]";
				String pattern4 = "\\d+,*\\d+원";//가격


				Matcher m1 = Pattern.compile(pattern1).matcher(str);
				Matcher m2 = Pattern.compile(pattern2).matcher(str);
				Matcher m3 = Pattern.compile(pattern3).matcher(str);
				Matcher m4 = Pattern.compile(pattern4).matcher(str);

				if(m1.find() && m2.find() && m3.find() && m4.find()) {

					System.out.println("===============================");
					String day = m1.group();
					String store = m2.group();
					String grade = m3.group();
					String detail = str.substring(m3.end(), m4.start()).trim();//trim은 양쪽 공백 아웃
					String price = m4.group();

					System.out.println(day);
					System.out.println(store);
					System.out.println(grade);
					System.out.println(price);
					System.out.println(detail);

					//1행을 Product 객체에 저장
					Product p = new Product(day, store, grade, detail, price);
					//product를 리스트.
					list.add(p);
				}				
			}//end while
			
			//엑셀 쓰기 호출
			createExcel(list);


		} catch (Exception e) {
			e.printStackTrace();
		}




	}

	public static void createExcel( List<Product> list) {

		//객체 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		//시트
		XSSFSheet sheet = workbook.createSheet();
		//시트안에 행
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("날짜");
		row1.createCell(1).setCellValue("지점");
		row1.createCell(2).setCellValue("등급");
		row1.createCell(3).setCellValue("상세");
		row1.createCell(4).setCellValue("가격");
		
		//리스트 엑셀파일
		for(int i = 0; i<list.size(); i++) {
			
			XSSFRow row = sheet.createRow(i+1);
			
			Product p = list.get(i); //리스트 안에 객체
			
			row.createCell(0).setCellValue(p.getDay());
			row.createCell(1).setCellValue(p.getStore());
			row.createCell(2).setCellValue(p.getGrade());
			row.createCell(3).setCellValue(p.getDetail());
			row.createCell(4).setCellValue(p.getPrice());
			
		}
		
		
		String path = "C:\\Users\\user\\Desktop\\course\\java\\work\\Quiz\\src\\quiz22\\건담.xlsx";
		
		
		try (FileOutputStream fos = new FileOutputStream(path)) {
			workbook.write(fos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}



}
