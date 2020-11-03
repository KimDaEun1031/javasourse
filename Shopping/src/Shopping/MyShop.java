package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop {
	
	private String title; // 쇼핑몰 이름	
	User[] users = new User[2]; // 사용자 수
	Product [] product = new Product[10]; // 등록상품 정보
	ArrayList<Product> carts = new ArrayList<Product>(); //장바구니
	Scanner sc = new Scanner(System.in); //키보드 입력 처리
	
	int selUser;

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void genUser() {
		//쇼핑몰 사용자 생성 후 배열에 담기
		//user 객체 이용
		users[0] = new User("김다은", PayType.CARD);
		users[1] = new User("진현주", PayType.CASH);
	
	}

	@Override
	public void genProduct() {
		//쇼핑몰에서 판매하는 제품 생성
		//CellPhone, SmartTV
		product [0] = new CellPhon("SKT", 870000, "갤럭시 9");
		product [1] = new CellPhon("KTfree", 1300000, "아이폰 11");
		product [2] = new CellPhon("KT", 5600000, "갤럭시 노트 5");
		product [3] = new CellPhon("SKT", 900000, "갤럭시 A9(2018)");
		product [4] = new CellPhon("KT", 1070000, "아이폰 4");
		product [5] = new SmartTV("4K", 1000000, "삼성 스마트 TV");
		product [6] = new SmartTV("HD", 2450000, "LG TV");
		product [7] = new SmartTV("4K", 4500000, "삼성 TV");
		product [8] = new SmartTV("Full HD", 67800000, "SKT TV");
		product [9] = new SmartTV("4K", 2300000, "삼성 TV");
	}
	

	@Override
	public void start() {
		//목적 : 모든 프로그램 시작 호출  / 시작하는 메소드
		System.out.println(title+" : 메인화면 - 계정선택");
		System.out.println("======================");	
		int i = 0;
		for(User u:users) {
			System.out.printf("[%d] %s(%s)\n",i++,u.getName(),u.getPaytype());
		}
		System.out.println("[x]종료");
		System.out.print("선택 : ");
		String input = sc.next();
		switch (input) {
		case "0": case "1":
			System.out.println("## "+input+"선택 ##");
			selUser = Integer.parseInt(input); //유저 선택
			prodectList();
			break;
		case "x": case "X":
			System.out.println("샵을 종료합니다.");
			break;
		default:
			System.out.println("\n입력값을 확인해 주세요.");
			start();
			break;
		}
//		if(input=="1") {
//			System.out.println("## "+input+"선택 ##" );
//		} else if(input=="2") {
//			System.out.println("## "+input+"선택 ##" );
//		} else if(input=='x') 
			
	}
	
	public void prodectList() {
		//제품 목록 출력하기
		int i=0;
		System.out.println(title+" : 상품 목록 - 상품 선택");
		System.out.println("======================");
		for(Product p:product) {
			System.out.printf("[%d]",i++);
			p.printDetail();
		}
		System.out.println("[h] 메인화면");
		System.out.println("[c] 체크아웃");
		System.out.print("선택 : ");
		String input = sc.next();
		switch (input) {
		case "h": case "H":
			start();
			break;
		case "c": case "C":
			checkout();
			break;
		case "1": case "2": case "3": case "4": case "5": case "6":
		case "7": case "8": case "9":
				carts.add(product[Integer.parseInt(input)]);	
				prodectList();
			break;
		default:
			System.out.println("\n입력값을 확인해 주세요.");
			prodectList();
			break;
		}	
		
	}
	
	public void checkout() {
		int i=0;
		int total=0;
		System.out.println("## c선택 ##");
		System.out.println(title+" : 체크아웃");		
		for(Product c:carts) {
			System.out.printf("[%d] %s(%s)\n",i++,c.getPname(),c.getPrice());
			total += c.getPrice();
		}
		System.out.println("======================");
		System.out.printf("결제 방법 : %s\n",users[selUser].getPaytype());
		System.out.println("합계 : "+total+"원입니다. ");
		System.out.println("[p] 이전 | [q] 결제 완료");
		System.out.print("선택 : ");
		String input = sc.next();
		switch (input) {
		case "p": case "P": //되돌아가면 고른 것은 추가가 됨
			checkout();
			break;
		case "q": case "Q":
			System.out.println("## 결제가 완료되었습니다. 종료합니다. ##");
			break;			
		default:
			System.out.println("\n입력값을 확인해 주세요.");
			checkout();
			break;
		}	
		
	}

}
