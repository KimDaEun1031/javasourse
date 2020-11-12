package Pattern;


import java.util.List;
import java.util.Scanner;

public class User_Main {

	

	public static void main(String[] args) {
		System.out.println("=====User TBL======");
	    System.out.println("1. 조회");
	    System.out.println("2. 삭제");
	    System.out.println("3. 수정");
	    System.out.println("4. 삽입");
	    System.out.println("===================");
	    
	    System.out.print("번호 입력 : ");
	    Scanner sc = new Scanner(System.in);
	    int menu = sc.nextInt();
	    
	    User_DAO dao = new User_DAO();
	    
	    switch (menu) {
		case 1:
			System.out.println("userTBL 전체 출력");
			List<User_VO> list = dao.getList();
			for(User_VO vo:list) {
				System.out.println(vo);
			}
			break;
		case 2:
			System.out.print("삭제할 회원번호 입력 : "  );
			int no = sc.nextInt();
			 boolean flag =dao.deleteUser(no);
			 System.out.println(flag?"삭제성공":"삭제실패");
			 List<User_VO> list1 = dao.getList();
				for(User_VO vo:list1) {
					System.out.println(vo);
				}			
			break;
		case 3:
			System.out.println("수정할 회원 정보 입력");
			System.out.print("수정할 회원 번호 입력 : ");
			no = sc.nextInt();
			System.out.print("수정할 회원 주소 입력 : ");
			String addr = sc.next();
			flag = dao.updateUser(addr, no);
			System.out.println(flag?"수정성공":"수정실패");
			List<User_VO> list2 = dao.getList();
			for(User_VO vo:list2) {
				System.out.println(vo);
			}						
			break;
		case 4:
			User_VO uvo = new User_VO();
			System.out.println("추가할 회원정보 입력");
			System.out.print("추가할 회원 이름 입력 : ");
			uvo.setUserName(sc.next());
//			String userName = sc.next();
//			uvo.setUserName(userName);
			System.out.print("추가할 회원 탄생일 입력 : ");
			int birthYear = sc.nextInt();
			uvo.setBirthYear(birthYear);
			System.out.print("추가할 회원 주소 입력 : ");
			addr = sc.next();
			uvo.setAddr(addr);
			System.out.print("추가할 회원 휴대폰번호 입력 : ");
			String mobile = sc.next();
			uvo.setMobile(mobile);		
//			flag=dao.insertUser(uvo);
//			System.out.println(flag?"삽입 성공":"삽입 실패");		
			System.out.println(dao.insertUser(uvo)?"삽입 성공":"삽입 실패");
			List<User_VO> list3 = dao.getList();
			for(User_VO vo:list3) {
				System.out.println(vo);
			}						
			break;

		}
	}

}
