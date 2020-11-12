package member.domain;

//하나의 클래스에 여러 것성자를 가지고 있는 것을 '생성자 오버로딩'
public class MemberVO {	
		private int id;
		private String name;
		private String addr;
		private String nation;
		private String email;
		private int age;
		
		public MemberVO() {
			super();
		}

		public MemberVO(String name, String addr, String nation, String email, int age) {
			super();
			this.name = name;
			this.addr = addr;
			this.nation = nation;
			this.email = email;
			this.age = age;
		}

		public MemberVO(int id, String name, String addr, String nation, String email, int age) {
			super();
			this.id = id;
			this.name = name;
			this.addr = addr;
			this.nation = nation;
			this.email = email;
			this.age = age;
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
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getNation() {
			return nation;
		}
		public void setNation(String nation) {
			this.nation = nation;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

}
