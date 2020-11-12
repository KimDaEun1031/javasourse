package member.ui;

import java.util.Scanner;

import member.action.Action;
import member.action.MemberAddAction;
import member.controller.MemberController;

public class MemberUi {

	public static void main(String[] args) {
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		do {
			System.out.println("******** ȸ�� ���� ���α׷� ********");
			System.out.println("1. ȸ�� ���");
			System.out.println("2. ȸ����� ����");
			System.out.println("3. ȸ������ ����");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ���α׷� ����");
			System.out.print("�޴� ���� : ");
			int menu = sc.nextInt();
			
			Action action = null;
			
			switch (menu) {
				case 1:
					action = new MemberAddAction();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
			}
			if(action!=null) {
				controller.processRequest(action, sc);
			}
		} while (!isStop);
		
	}

}
