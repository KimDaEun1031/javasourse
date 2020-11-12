package Pattern;


import java.util.List;
import java.util.Scanner;

public class User_Main {

	

	public static void main(String[] args) {
		System.out.println("=====User TBL======");
	    System.out.println("1. ��ȸ");
	    System.out.println("2. ����");
	    System.out.println("3. ����");
	    System.out.println("4. ����");
	    System.out.println("===================");
	    
	    System.out.print("��ȣ �Է� : ");
	    Scanner sc = new Scanner(System.in);
	    int menu = sc.nextInt();
	    
	    User_DAO dao = new User_DAO();
	    
	    switch (menu) {
		case 1:
			System.out.println("userTBL ��ü ���");
			List<User_VO> list = dao.getList();
			for(User_VO vo:list) {
				System.out.println(vo);
			}
			break;
		case 2:
			System.out.print("������ ȸ����ȣ �Է� : "  );
			int no = sc.nextInt();
			 boolean flag =dao.deleteUser(no);
			 System.out.println(flag?"��������":"��������");
			 List<User_VO> list1 = dao.getList();
				for(User_VO vo:list1) {
					System.out.println(vo);
				}			
			break;
		case 3:
			System.out.println("������ ȸ�� ���� �Է�");
			System.out.print("������ ȸ�� ��ȣ �Է� : ");
			no = sc.nextInt();
			System.out.print("������ ȸ�� �ּ� �Է� : ");
			String addr = sc.next();
			flag = dao.updateUser(addr, no);
			System.out.println(flag?"��������":"��������");
			List<User_VO> list2 = dao.getList();
			for(User_VO vo:list2) {
				System.out.println(vo);
			}						
			break;
		case 4:
			User_VO uvo = new User_VO();
			System.out.println("�߰��� ȸ������ �Է�");
			System.out.print("�߰��� ȸ�� �̸� �Է� : ");
			uvo.setUserName(sc.next());
//			String userName = sc.next();
//			uvo.setUserName(userName);
			System.out.print("�߰��� ȸ�� ź���� �Է� : ");
			int birthYear = sc.nextInt();
			uvo.setBirthYear(birthYear);
			System.out.print("�߰��� ȸ�� �ּ� �Է� : ");
			addr = sc.next();
			uvo.setAddr(addr);
			System.out.print("�߰��� ȸ�� �޴�����ȣ �Է� : ");
			String mobile = sc.next();
			uvo.setMobile(mobile);		
//			flag=dao.insertUser(uvo);
//			System.out.println(flag?"���� ����":"���� ����");		
			System.out.println(dao.insertUser(uvo)?"���� ����":"���� ����");
			List<User_VO> list3 = dao.getList();
			for(User_VO vo:list3) {
				System.out.println(vo);
			}						
			break;

		}
	}

}
