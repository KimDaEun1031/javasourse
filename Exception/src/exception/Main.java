package exception;

public class Main {

	public static void main(String[] args) {
		//������ ����
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("�Է°��� Ȯ���� �ּ���.");
		}

	}

}
