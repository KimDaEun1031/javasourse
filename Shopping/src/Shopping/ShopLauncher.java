package Shopping;

public class ShopLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyShop shop = new MyShop();
		
		//���� �̸� ����
		shop.setTitle("�޴����˴ϴ�");
		//User ����
		shop.genUser();
		//��ǰ ����
		shop.genProduct();
		//���� ����
		shop.start();
	}

}
