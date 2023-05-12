package day11.inter.basic3;

public class LG implements Printed{ //추상이랑 비슷하다.

	private String logo = "Life is good"; //자기만의 기능 private!
	
	@Override
	public void print(String document) {
		System.out.println(logo);
		System.out.println(document);
		
	}

	@Override
	public void colorPrint(String document, String color) {
		System.out.println(logo);
		System.out.println("color : " + color);
		System.out.println(color + "색상" + document);
		
	}

	@Override
	public int copy(int n) {
		
		for(int i = 0; i<n; i++) {
			System.out.println(i+"장 복사ing");
		}
		
		return 1; //완료시 1을 반환.
		
		
	}

}
