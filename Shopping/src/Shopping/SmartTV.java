package Shopping;

public class SmartTV extends Product{
	private String resolution; //�ػ�

	public SmartTV(String resolution, int price, String pname) {
		super(pname, price); //�θ� Ŭ������ ������ �ʿ� ��? 
		this.resolution = resolution;
	}

	@Override
	void pirntExtra() {
		System.out.println("�ػ� ���� : "+resolution);
	}

	
	
}
