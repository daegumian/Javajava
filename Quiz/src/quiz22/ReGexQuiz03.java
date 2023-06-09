package quiz22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import quiz21.Data;


public class ReGexQuiz03 {

	public static void main(String[] args) {

		/*
		 * 1. 버퍼리더를 사용해서 건담.txt를 읽어들인다.(readLin으로 한 줄씩 읽어들임)
		 * 2. 정규표현식을 이용해서 날짜, 지점, 등급, 내용, 가격 을 정규표현식으로 패턴분석
		 * 	  Product 객체에 저장하고, 리스트에 저장
		 * 
		 * 3. 외부라이브러리 (POI) - 자바에서 엑셀파일 xlsx 형태로 파일을 쓸 수 있도록하는 기능
		 * 	  하나에 시트에 각 행데이터를 엑셀 파일로 출력.
		 * 
		 * 	
		 */

		String path = "C:\\Users\\user\\Documents\\카카오톡 받은 파일\\건담.txt";
		String str;
		String pattern1 = "[0-9]+-[0-9]+-[0-9]+";
		String pattern2 = "[건담(베이스)]+\\s[가-힝]+";
		String pattern3 = "\\[[A-Z가-힝]+\\]";
		String pattern4 = "[\\]+](.*) [\\S]";
		String pattern5 = "[0-9,]+원";

		List<Product> product = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){


			while((str = br.readLine()) != null) {

				String[] arr = str.split("\n");

				List<String> list = Arrays.asList(arr);

				for (int i = 0; i < list.size(); i++) {

					String str2 = list.get(i);	

					Matcher x1 = Pattern.compile(pattern1).matcher(str2);
					Matcher x2 = Pattern.compile(pattern2).matcher(str2);
					Matcher x3 = Pattern.compile(pattern3).matcher(str2);
					Matcher x4 = Pattern.compile(pattern4).matcher(str2);
					Matcher x5 = Pattern.compile(pattern5).matcher(str2);

					if(x1.find() &&x2.find() &&x3.find() &&x4.find() &&x5.find()) {
						//System.out.println("---------------");
						//System.out.println(x1.group());
						//System.out.println(x2.group());
						//System.out.println(x3.group());
						//System.out.println(x4.group().replaceAll("] ", "").substring(0, x4.group().length()-3));
						//System.out.println(x5.group());
						Product data = new Product(x1.group()
								,x2.group()
								, x3.group()
								, x4.group().replaceAll("] ", "").substring(0, x4.group().length()-3)
								, x5.group());
						product.add(data); //product 객체에 집어 넣는법

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		for (Product p : product) {//리스트에 잘 들어갔는지 확인하는 작업
			System.out.println(p.toString());
		}

		Workbook xlsWb = new XSSFWorkbook();
		Sheet sheet = xlsWb.createSheet("건담");
		int rowNo = 0;
		Cell cell = null;

		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Day");
		headerRow.createCell(1).setCellValue("Store");
		headerRow.createCell(2).setCellValue("Grade");
		headerRow.createCell(3).setCellValue("Detail");
		headerRow.createCell(4).setCellValue("Price");

		for (Product p : product) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(p.getDay());
			row.createCell(1).setCellValue(p.getStore());
			row.createCell(2).setCellValue(p.getGrade());
			row.createCell(3).setCellValue(p.getDetail());
			row.createCell(4).setCellValue(p.getPrice());
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(new File("C:\\Users\\user\\Desktop\\course\\건담.xls"));

			xlsWb.write(fileOut);
			System.out.println("엑셀 파일이 생성되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();

		}


	}

}
