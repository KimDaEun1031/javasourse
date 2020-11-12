package member.ui;

import java.util.Scanner;

import member.domain.MemberVO;

public class MemberConsoleUtil {
	public MemberVO getAddMember(Scanner sc) {
		MemberVO vo = new MemberVO();
		System.out.println("등록할 회원 정보를 입력하세요");
		System.out.print("아이디 : ");
		int id = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주소 : ");
		String addr = sc.nextLine();	
		System.out.print("국가 : ");
		String nation = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		return new MemberVO(id, name, addr, nation, email, age);
				
	}
	
	public void printAddSuccessMessage(String name) {
		System.out.println(name + "회원 정보 추가 성공");
	}
}
