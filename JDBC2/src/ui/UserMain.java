package ui;


import java.util.List;
import java.util.Scanner;

import action.Action;
import action.UserAddAction;
import action.UserListAction;
import action.UserLowAction;
import action.UserRemoveAction;
import action.UserUpdateAction;
import controller.UserController;

public class UserMain {

	

	public static void main(String[] args) {
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		UserController userController = new UserController();
		do {
			System.out.println("====== 사용자 메뉴 ======");
		    System.out.println("1. 전체 조회");
		    System.out.println("2. 개별 조회");
		    System.out.println("3. 삭제");
		    System.out.println("4. 수정");
		    System.out.println("5. 삽입");
		    System.out.println("6. 프로그램 종료");
		    System.out.println("======================");
		    
		    System.out.print("번호 입력 : ");		    
		    int menu = sc.nextInt();
		    
		    Action action = null;
		    
		    switch (menu) {
			case 1:
				action = new UserListAction();
				break;
			case 2:
				action = new UserLowAction();
				break;
			case 3:
				action = new UserRemoveAction();
				break;
			case 4:
				action = new UserUpdateAction();
				break;
			case 5:
				action = new UserAddAction();
				break;
			case 6:
				System.out.println("프로그램 종료");
				isStop = true; //반복문 종료
				break;
			}
		    if(action != null) { 
		    	//null이 아니라면
		    	//=>31번줄만 놔두면 이렇게 되요..
		    	// 그리고 44번과 같은 코드가 실행되면 deadcode 는 없어지는 거!!!
		    	userController.processRequset(action, sc);
		    }
		    		
		    
		} while(!isStop);
		
	}
}
