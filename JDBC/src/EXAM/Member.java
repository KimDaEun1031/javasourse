package EXAM;

public class Member {
	private int id;
	private String name;
	
	public Member(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() { //객체를 내가 원하는 문자로 받기 위한
		return "Member [id=" + id + ", name=" + name + "]";
	}

}
