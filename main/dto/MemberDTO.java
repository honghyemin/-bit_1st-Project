package kr.co.bit.library.main.dto;

public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String hint;
	
	public MemberDTO(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public MemberDTO(String id, String password, String name, String address, String phone, String hint) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.hint = hint;
	}

	public MemberDTO() {
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getHint() {
		return hint;
	}

	public void setHint(String hitn) {
		this.hint = hint;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", hint=" + hint + "]";
	}

	
	
	
	
	
	
	

}
