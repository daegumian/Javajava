package quiz01;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수1:");
		int a = scan.nextInt();
		System.out.print("연산을 선택하세요[+,-,*,/]:");
		String c = scan.next();
		
		System.out.println("정수2:");
		int b = scan.nextInt();
		
		switch(c) {
		case "+": System.out.println("두 수의 덧셈은:"+(a+b));
		break;
		case "-": System.out.println("두 수의 뺄셈은:"+(a-b));
		break;
		case "*": System.out.println("두 수의 곱셈은:"+(a*b));
		break;
		default : System.out.println("두 수의 나눗셈은:"+(a/b));
		}
		
		scan.close();
		
		//정답
//		
//		System.out.println("정수1>");
//		int n1 = scan.nextInt();
//		
//		System.out.println("연산을 선택하세요[+-*/]>");
//		String oper = scan.next();
//		
//		System.out.println("정수2>");
//		int n2 = scan.nextInt();
//		
//		switch (oper) {
//		case "+":
//			System.out.println("두 수의 합은:"+ (n1+n2));
//			break;
//		case "-":
//			System.out.println("두 수의 차는:"+ (n1-n2));
//			break;
//		case "*":
//			System.out.println("두 수의 곱은:"+ (n1*n2));
//			break;
//		case "/":
//			System.out.println("두 수의 나눗셈:"+ (n1/n2));
//			break;
//		default :
//			System.out.println("연산자는[=-*/]입니다.");
//		}
		
	}
}
