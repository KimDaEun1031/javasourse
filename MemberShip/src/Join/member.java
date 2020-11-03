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
			System.out.println("회원 가입에 오신 것을 환영합니다.");
			System.out.println("=========================");
			System.out.println("아이디 : ");
			id = sc.next();
			users.setId(id);
			//아이디 중복 확인   id값을 분리해서 비교한 뒤에 안맞으면 넘기고 맞으면 중복으로
//			user [i] = users.getId(); 
//			if(user[0].equals(user[i]) && i>=1) {
//				System.out.println("중복! 사용 할 수 없습니다.");		
//				join();
//			}
			System.out.println("패스워드 : ");
			password = sc.next();
			users.setPassword(password);
			System.out.println("닉네임 : ");
			nickname = sc.next();
			users.setNickname(nickname);
			System.out.println("이메일 : ");
			email = sc.next();
			users.setEmail(email);
			System.out.println("=========================================");
			System.out.printf("아이디 : %s\t패스워드 : %s\n닉네임 : %s\t이메일 : %s\n",
					users.getId(),users.getPassword(),users.getNickname(),users.getEmail());
			//아이디 중복 확인
			
		}
			
	}

}
