package Shopping;

/*	추상 메소드 - 객체 생성 불가
 *  		 - 단일 상속
 *           - 추상 + 일반 메소드 가짐
 */

public abstract class Product {
	private String pname;
	private int price;
	
	public Product(String pname, int price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	
	void printDetail() {
		System.out.println("상품이름 : " +pname);
		System.out.println("상품가격 : " +price+"원");
		pirntExtra();
	}
	
	abstract void pirntExtra();
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
