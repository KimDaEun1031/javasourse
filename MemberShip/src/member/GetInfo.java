package member;

import java.util.ArrayList;
import java.util.HashSet;
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
			System.out.println("##===== OO Ŀ�´�Ƽ�� ���� ���� ȯ���մϴ�. =====##");
			System.out.println("ȸ�������� �Ͻ÷��� [H] ��ư�� �����ּ���.");
			System.out.println("ȸ�������� �Ͻ��� �������� [X] ��ư�� �����ּ���.");
			input = sc.next();
			switch (input) {
			case "h": case "H":
				MemberShip();
				break;
			case "x": case "X":
				System.out.println("Ŀ�´�Ƽ�� �����մϴ�.");
				break;

			default:
				System.out.println("�Է� ���� Ȯ�����ּ���.");
				start();
				break;
			}
		}
		
		void MemberShip() {
			
			members.add(new User("kimde1031","yuko453728","����",
					"kly48204lp@gmail.com","01044789078")); // members�� 0��° ��(����)
			members.add(new User("nass0205","shna@1203","���������",
					"nasy0205@gmail.com","01064502949")); // members�� 1��° ��
			members.add(new User("htkim5098","ht@55879","�컫����",
					"htkim5098@gmail.com","01045321178")); // members�� 2��° ��
			members.add(new User("hyenju33","jhjpk10231203","�Ϳ���ǪŰ",
					"hyenjukaii@gmail.com","01066181004")); // members�� 3��° ��
			members.add(new User("yuki0913","yuki@99922876","���ڴ°���",
					"yuki@gmail.com","01011114444")); // members�� 4��° ��
			
			System.out.printf("\n\nȸ�������� ��� �Ͻ÷��� [E] ��ư�� �����ּ���.");
			System.out.printf("���� ������ ���ư��Ƿ��� [P] ��ư�� �����ּ���.\n\n");
			input = sc.next();
			
			switch (input) {
			case "e": case "E": 
				System.out.println("##===== ȸ�� ���� ������ =====##");
				System.out.print("���̵� : ");
				id = sc.next();	
				users.setId(id);
				

				System.out.print("��й�ȣ : ");
				password = sc.next();
				users.setPassword(password);
				
				System.out.print("�г��� : ");
				nickname = sc.next();
				users.setNickname(nickname);
				
				System.out.print("�̸��� : ");
				email = sc.next();
				users.setEmail(email);
	
				System.out.print("�޴�����ȣ : ");
				phoneNumber = sc.next();
				users.setPhoneNumber(phoneNumber);
						
				members.add(users);
				
//				for(int j=members.size()-1;j<members.size();) {
//					for(int i=0;i<j;i++) {								
//						if(members.get(j).getId().equals(members.get(i).toString(id))) {
//							String mem = members.get(i).toString(id);
//							System.out.println(mem);
//							String me = members.get(j).getId();
//							System.out.println(me);
//							System.out.println("�ߺ�������");
//							break;
//						}
//					}
//				}
//				MemberInfo();

				break;
	
			default:
				break;
			}
	
	}
		
		void MemberInfo() {
			String mem = members.get(5).toString(id);
			String me = members.get(5).getId();
			System.out.println(me);


			
		}
}
