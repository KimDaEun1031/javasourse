package Shopping;

public class CellPhon extends Product{
	private String carrier; //��Ż�
	
	public CellPhon(String carrier, int price, String pname) {
		super(pname, price);
		this.carrier = carrier;
	}

	@Override
	void pirntExtra() {
		System.out.println("��Ż� ���� : "+carrier);
	}

	
	
}
