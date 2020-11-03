package Shopping;

public class CellPhon extends Product{
	private String carrier; //통신사
	
	public CellPhon(String carrier, int price, String pname) {
		super(pname, price);
		this.carrier = carrier;
	}

	@Override
	void pirntExtra() {
		System.out.println("통신사 정보 : "+carrier);
	}

	
	
}
