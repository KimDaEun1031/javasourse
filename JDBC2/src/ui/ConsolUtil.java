package ui;

import java.util.List;
import java.util.Scanner;

import domain.User_VO;

//�ַܼκ��� ����ڰ� �Է��� ������ �о���̰ų�
//�ַܼ� �ʿ��� �޼����� ���
public class ConsolUtil {
	public User_VO getNewUser(Scanner sc) {
		
		User_VO vo = new User_VO();
		System.out.println("=== User �߰� ===");
		System.out.print("�߰��� ȸ�� �̸� �Է� : ");
		vo.setUserName(sc.next());
//		String userName = sc.next();
//		uvo.setUserName(userName);
		System.out.print("�߰��� ȸ�� ź���� �Է� : ");
		vo.setBirthYear(sc.nextInt());
		System.out.print("�߰��� ȸ�� �ּ� �Է� : ");
		vo.setAddr(sc.next());
		System.out.print("�߰��� ȸ�� �޴�����ȣ �Է� : ");
		vo.setMobile(sc.next());
		
		return vo;
	}
	
	//user �Է� ���� �޽���
		public void printAddSuccessMessage(User_VO user) {
			System.out.println(user.getUserName() + "���� �߰� ����");
		}
		//user �Է� ���� �޽���
		public void printAddFailSuccessMessage(User_VO user) {
			System.out.println(user.getUserName() + "���� �߰� ����");
		}
	
		
	//��ü ��ȸ ����ϱ�
		public void printUserList(List<User_VO> list) {
			System.out.println("==== User ��ü ��� ====");

			for(User_VO vo:list) {
				System.out.println(vo);
			}
		}
		
	//���� ��ȸ
		public int printUserRow(Scanner sc) {
			System.out.print("��ȸ�� ����� ��ȣ : ");
			int no = sc.nextInt();
			return no;
			
		}
		public void printUserDetail(User_VO user) {
			System.out.println("=== ��ȸ�� ����ڴ� ������ �����ϴ�. ===");
			System.out.println(user);
		}
		
		
		 //user ���� ��ȣ ��ȸ
			public int printUserRemove(Scanner sc) {
				System.out.println("=== User ���� ===");
				System.out.print("������ ����� ��ȣ : ");
				int no = sc.nextInt();
				return no;
			}
		
		//user ���� ���� �޽���
			public void printRemoveSuccessMessage() {
				System.out.println("User ���� ����");
			}
		//user ���� ���� �޽���
			public void printRemoveFailSuccessMessage() {
				System.out.println("User ���� ����");
			}
			
		
		//user ���� ���
		public User_VO printUpdateMessage(Scanner sc) {
			System.out.println("=== User ���� ===");
			System.out.print("������ ȸ�� ��ȣ �Է� : ");
			int no = sc.nextInt();
			System.out.print("������ ȸ�� �ּ� �Է� : ");
			String addr = sc.next();
			
			User_VO vo = new User_VO();
			vo.setNo(no);
			vo.setAddr(addr);
			return vo;
		}
		
		//user ���� ���� �޽���
		public void printUpdateSuccessMessage() {
			System.out.println("User ���� ����");
		}
		//user ���� ���� �޽���
		public void printUpdateFailMessage() {
			System.out.println("User ���� ����");
		}
}
