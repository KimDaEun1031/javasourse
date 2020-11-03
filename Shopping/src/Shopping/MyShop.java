package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop {
	
	private String title; // ���θ� �̸�	
	User[] users = new User[2]; // ����� ��
	Product [] product = new Product[10]; // ��ϻ�ǰ ����
	ArrayList<Product> carts = new ArrayList<Product>(); //��ٱ���
	Scanner sc = new Scanner(System.in); //Ű���� �Է� ó��
	
	int selUser;

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void genUser() {
		//���θ� ����� ���� �� �迭�� ���
		//user ��ü �̿�
		users[0] = new User("�����", PayType.CARD);
		users[1] = new User("������", PayType.CASH);
	
	}

	@Override
	public void genProduct() {
		//���θ����� �Ǹ��ϴ� ��ǰ ����
		//CellPhone, SmartTV
		product [0] = new CellPhon("SKT", 870000, "������ 9");
		product [1] = new CellPhon("KTfree", 1300000, "������ 11");
		product [2] = new CellPhon("KT", 5600000, "������ ��Ʈ 5");
		product [3] = new CellPhon("SKT", 900000, "������ A9(2018)");
		product [4] = new CellPhon("KT", 1070000, "������ 4");
		product [5] = new SmartTV("4K", 1000000, "�Ｚ ����Ʈ TV");
		product [6] = new SmartTV("HD", 2450000, "LG TV");
		product [7] = new SmartTV("4K", 4500000, "�Ｚ TV");
		product [8] = new SmartTV("Full HD", 67800000, "SKT TV");
		product [9] = new SmartTV("4K", 2300000, "�Ｚ TV");
	}
	

	@Override
	public void start() {
		//���� : ��� ���α׷� ���� ȣ��  / �����ϴ� �޼ҵ�
		System.out.println(title+" : ����ȭ�� - ��������");
		System.out.println("======================");	
		int i = 0;
		for(User u:users) {
			System.out.printf("[%d] %s(%s)\n",i++,u.getName(),u.getPaytype());
		}
		System.out.println("[x]����");
		System.out.print("���� : ");
		String input = sc.next();
		switch (input) {
		case "0": case "1":
			System.out.println("## "+input+"���� ##");
			selUser = Integer.parseInt(input); //���� ����
			prodectList();
			break;
		case "x": case "X":
			System.out.println("���� �����մϴ�.");
			break;
		default:
			System.out.println("\n�Է°��� Ȯ���� �ּ���.");
			start();
			break;
		}
//		if(input=="1") {
//			System.out.println("## "+input+"���� ##" );
//		} else if(input=="2") {
//			System.out.println("## "+input+"���� ##" );
//		} else if(input=='x') 
			
	}
	
	public void prodectList() {
		//��ǰ ��� ����ϱ�
		int i=0;
		System.out.println(title+" : ��ǰ ��� - ��ǰ ����");
		System.out.println("======================");
		for(Product p:product) {
			System.out.printf("[%d]",i++);
			p.printDetail();
		}
		System.out.println("[h] ����ȭ��");
		System.out.println("[c] üũ�ƿ�");
		System.out.print("���� : ");
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
			System.out.println("\n�Է°��� Ȯ���� �ּ���.");
			prodectList();
			break;
		}	
		
	}
	
	public void checkout() {
		int i=0;
		int total=0;
		System.out.println("## c���� ##");
		System.out.println(title+" : üũ�ƿ�");		
		for(Product c:carts) {
			System.out.printf("[%d] %s(%s)\n",i++,c.getPname(),c.getPrice());
			total += c.getPrice();
		}
		System.out.println("======================");
		System.out.printf("���� ��� : %s\n",users[selUser].getPaytype());
		System.out.println("�հ� : "+total+"���Դϴ�. ");
		System.out.println("[p] ���� | [q] ���� �Ϸ�");
		System.out.print("���� : ");
		String input = sc.next();
		switch (input) {
		case "p": case "P": //�ǵ��ư��� �� ���� �߰��� ��
			checkout();
			break;
		case "q": case "Q":
			System.out.println("## ������ �Ϸ�Ǿ����ϴ�. �����մϴ�. ##");
			break;			
		default:
			System.out.println("\n�Է°��� Ȯ���� �ּ���.");
			checkout();
			break;
		}	
		
	}

}
