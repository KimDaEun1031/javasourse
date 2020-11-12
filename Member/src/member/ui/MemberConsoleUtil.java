package member.ui;

import java.util.Scanner;

import member.domain.MemberVO;

public class MemberConsoleUtil {
	public MemberVO getAddMember(Scanner sc) {
		MemberVO vo = new MemberVO();
		System.out.println("����� ȸ�� ������ �Է��ϼ���");
		System.out.print("���̵� : ");
		int id = sc.nextInt();
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�ּ� : ");
		String addr = sc.nextLine();	
		System.out.print("���� : ");
		String nation = sc.next();
		System.out.print("�̸��� : ");
		String email = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();
		return new MemberVO(id, name, addr, nation, email, age);
				
	}
	
	public void printAddSuccessMessage(String name) {
		System.out.println(name + "ȸ�� ���� �߰� ����");
	}
}
