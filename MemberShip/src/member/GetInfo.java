package member;

import java.util.ArrayList;
import java.util.Scanner;

public class GetInfo {
		Scanner sc = new Scanner(System.in);
		private String id;
		private String password;
		private String nickname; 
		private String email;
		private String phoneNumber;
		String input;
		
		
		User users = new User(id, password, nickname, email, phoneNumber);
		ArrayList<User> members = new ArrayList<User>();
		
		void start() {
			System.out.println("##===== OO 커뮤니티에 오신 것을 환영합니다. =====##");
			System.out.println("회원가입을 하시려면 [H] 버튼을 눌러주세요.");
			System.out.println("회원가입을 하시지 않으려면 [X] 버튼을 눌러주세요.");
			input = sc.next();
			switch (input) {
			case "h": case "H":
				MemberShip();
				break;
			case "x": case "X":
				System.out.println("커뮤니티를 종료합니다.");
				break;

			default:
				System.out.println("입력 값을 확인해주세요.");
				start();
				break;
			}
		}
		
		void MemberShip() {
			
			members.add(new User("kimde1031","yuko453728","곰돌",
					"kly48204lp@gmail.com","01044789078")); // members의 0번째 값(기준)
			members.add(new User("nass0205","shna@1203","검은고양이",
					"nasy0205@gmail.com","01064502949")); // members의 1번째 값
			members.add(new User("htkim5098","ht@55879","살뺀돼지",
					"htkim5098@gmail.com","01045321178")); // members의 2번째 값
			members.add(new User("hyenju33","jhjpk10231203","귀여운푸키",
					"hyenjukaii@gmail.com","01066181004")); // members의 3번째 값
			members.add(new User("yuki0913","yuki@99922876","잠자는공주",
					"yuki@gmail.com","01011114444")); // members의 4번째 값
			
			System.out.printf("\n\n회원가입을 계속 하시려면 [E] 버튼을 눌러주세요.");
			System.out.printf("메인 페이지 돌아가실려면 [P] 버튼을 눌러주세요.\n\n");
			input = sc.next();
			
			switch (input) {
			case "e": case "E": 
				System.out.println("##===== 회원 가입 페이지 =====##");
				System.out.print("아이디 : ");
				id = sc.next();				
				
				System.out.print("비밀번호 : ");
				password = sc.next();
				users.setPassword(password);
				
				System.out.print("닉네임 : ");
				nickname = sc.next();
				users.setNickname(nickname);
				
				System.out.print("이메일 : ");
				email = sc.next();
				users.setEmail(email);
	
				System.out.print("휴대폰번호 : ");
				phoneNumber = sc.next();
				users.setPhoneNumber(phoneNumber);
						
				members.add(users);
				MemberInfo();

				break;
	
			default:
				break;
			}
	
	}
		
		void MemberInfo() {
			String mem = members.get(5).toString();
			System.out.println(mem);


			
		}
}
