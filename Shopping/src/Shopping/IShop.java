package Shopping;

public interface IShop {
	void setTitle(String title);	
	void genUser();
	void genProduct();
	void start();
	//default, static가 붙으면 일반메소드도 들어올 수 있다. 무조건 붙어야함
	//원래는 추상메소드와 상수만 가능 8이후 부터 위에것이 됨
}
