package Shopping;

public class ShopLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyShop shop = new MyShop();
		
		//상점 이름 지정
		shop.setTitle("휴대폰팝니다");
		//User 생성
		shop.genUser();
		//제품 생성
		shop.genProduct();
		//상점 시작
		shop.start();
	}

}
