package Join;

import java.util.Scanner;

public class member implements Membership {
	private String id;
	private String password;
	private String nickname;
	private String email;

	UserId users = new UserId(id, password, nickname, email);
	String [] user = new String[10];
	Scanner sc = new Scanner(System.in);

	@Override
	public void join() {
		int i=0;
		for(;i<user.length;) {
			System.out.println("ȸ�� ���Կ� ���� ���� ȯ���մϴ�.");
			System.out.println("=========================");
			System.out.println("���̵� : ");
			id = sc.next();
			users.setId(id);
			//���̵� �ߺ� Ȯ��   id���� �и��ؼ� ���� �ڿ� �ȸ����� �ѱ�� ������ �ߺ�����
//			user [i] = users.getId(); 
//			if(user[0].equals(user[i]) && i>=1) {
//				System.out.println("�ߺ�! ��� �� �� �����ϴ�.");		
//				join();
//			}
			System.out.println("�н����� : ");
			password = sc.next();
			users.setPassword(password);
			System.out.println("�г��� : ");
			nickname = sc.next();
			users.setNickname(nickname);
			System.out.println("�̸��� : ");
			email = sc.next();
			users.setEmail(email);
			System.out.println("=========================================");
			System.out.printf("���̵� : %s\t�н����� : %s\n�г��� : %s\t�̸��� : %s\n",
					users.getId(),users.getPassword(),users.getNickname(),users.getEmail());
			//���̵� �ߺ� Ȯ��
			
		}
			
	}

}
