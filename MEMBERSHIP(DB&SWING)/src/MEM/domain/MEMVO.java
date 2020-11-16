package MEM.domain;

public class MEMVO {
	private int no;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String tel;
	private String pw_hint;
	
	public MEMVO() {
		super();
	}
	
	public MEMVO(int no, String id, String password, String nickname, String email, String tel, String pw_hint) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
		this.pw_hint = pw_hint;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPw_hint() {
		return pw_hint;
	}

	public void setPw_hint(String pw_hint) {
		this.pw_hint = pw_hint;
	}
}
