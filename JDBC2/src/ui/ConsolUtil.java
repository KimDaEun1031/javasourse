package ui;

import java.util.List;
import java.util.Scanner;

import domain.User_VO;

//콘솔로부터 사용자가 입력한 정보를 읽어들이거나
//콘솔로 필요한 메세지를 출력
public class ConsolUtil {
	public User_VO getNewUser(Scanner sc) {
		
		User_VO vo = new User_VO();
		System.out.println("=== User 추가 ===");
		System.out.print("추가할 회원 이름 입력 : ");
		vo.setUserName(sc.next());
//		String userName = sc.next();
//		uvo.setUserName(userName);
		System.out.print("추가할 회원 탄생일 입력 : ");
		vo.setBirthYear(sc.nextInt());
		System.out.print("추가할 회원 주소 입력 : ");
		vo.setAddr(sc.next());
		System.out.print("추가할 회원 휴대폰번호 입력 : ");
		vo.setMobile(sc.next());
		
		return vo;
	}
	
	//user 입력 성공 메시지
		public void printAddSuccessMessage(User_VO user) {
			System.out.println(user.getUserName() + "정보 추가 성공");
		}
		//user 입력 실패 메시지
		public void printAddFailSuccessMessage(User_VO user) {
			System.out.println(user.getUserName() + "정보 추가 실패");
		}
	
		
	//전체 조회 출력하기
		public void printUserList(List<User_VO> list) {
			System.out.println("==== User 전체 출력 ====");

			for(User_VO vo:list) {
				System.out.println(vo);
			}
		}
		
	//개별 조회
		public int printUserRow(Scanner sc) {
			System.out.print("조회할 사용자 번호 : ");
			int no = sc.nextInt();
			return no;
			
		}
		public void printUserDetail(User_VO user) {
			System.out.println("=== 조회한 사용자는 다음과 같습니다. ===");
			System.out.println(user);
		}
		
		
		 //user 삭제 번호 조회
			public int printUserRemove(Scanner sc) {
				System.out.println("=== User 삭제 ===");
				System.out.print("삭제할 사용자 번호 : ");
				int no = sc.nextInt();
				return no;
			}
		
		//user 삭제 성공 메시지
			public void printRemoveSuccessMessage() {
				System.out.println("User 삭제 성공");
			}
		//user 삭제 실패 메시지
			public void printRemoveFailSuccessMessage() {
				System.out.println("User 삭제 실패");
			}
			
		
		//user 수정 출력
		public User_VO printUpdateMessage(Scanner sc) {
			System.out.println("=== User 수정 ===");
			System.out.print("수정할 회원 번호 입력 : ");
			int no = sc.nextInt();
			System.out.print("수정할 회원 주소 입력 : ");
			String addr = sc.next();
			
			User_VO vo = new User_VO();
			vo.setNo(no);
			vo.setAddr(addr);
			return vo;
		}
		
		//user 수정 성공 메시지
		public void printUpdateSuccessMessage() {
			System.out.println("User 수정 성공");
		}
		//user 수정 성공 메시지
		public void printUpdateFailMessage() {
			System.out.println("User 수정 실패");
		}
}
