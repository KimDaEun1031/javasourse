package member;

public class User {
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String phoneNumber;
	
	public User(String id, String password, String nickname, String email, 
			String phoneNumber) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		
	@Override

	public String toString() {

		return "##========== 회원 가입 완료 ==========##" +
				"\nID            | " + id + 
				"\nPASSWORD      | " + password +
				"\nNICKNAME      | " + nickname +
				"\nEMAIL         | " + email +
			    "\nPHONENUMBER   | " + phoneNumber +
			    "\n##================================##";

	}




}
