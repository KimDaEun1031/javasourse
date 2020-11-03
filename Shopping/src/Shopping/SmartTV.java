package Shopping;

public class SmartTV extends Product{
	private String resolution; //해상도

	public SmartTV(String resolution, int price, String pname) {
		super(pname, price); //부모 클래스에 생성자 필요 왜? 
		this.resolution = resolution;
	}

	@Override
	void pirntExtra() {
		System.out.println("해상도 정보 : "+resolution);
	}

	
	
}
