package exception;

public class Main {

	public static void main(String[] args) {
		//컴파일 예외
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("입력값을 확인해 주세요.");
		}

	}

}
