package quiz10;

public class User {

	/* 문제1
	 * 1. 클래스 User를 생성하세요
	 * 2. 멤버변수 name: String ,  rrn : int, int age 를 선언후 은닉 처리합니다 (private 지정)
	 * 3. User 클래스에는 기본생성자, 모든 멤버변수를  초기화 하는 생성자  2개를 생성하세요.
	 * 4. main에서 User객체를  생성 후  
	 *    (홍길동, 123123, 20)을 저장 하고 값을 확인하세요.
	 */
	public User() {
		
	}
	
	public User(String name, int rrn, int age) {
		super();
		this.name = name;
		this.rrn = rrn;
		this.age = age;
	}
	
	
	private User[] arr = new User[2];


	public User[] getArr() {
		return arr;
	}

	public void setArr(User[] arr) {
		this.arr = arr;
	}


	private String name;
	private int rrn;
	private int age;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRrn() {
		return rrn;
	}

	public void setRrn(int rrn) {
		this.rrn = rrn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	/* 문제2
	 * 1. 메인에서 2개의 크기를 갖는 User배열을 선언하세요. (User배열은 User클래스를 저장할 수 있습니다.)
	 * 2. 메인에서 두번째 User객체를 생성하세요. ("김길동", 456456, 30)을 저장.
	 * 3. 메인에서 User배열에 두 객체를 저장하세요.
		 * 4. 향상된 포문을 사용해서  *모든변수*를 출력하세요.
		 * ex) User[] arr = new User[2];
	 */
	

	
	
	
	





}



