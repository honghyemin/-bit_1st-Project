package kr.co.bit.library.main.dto;

import java.util.Date;

public class BookedBookDTO {
	
	private int serialNumber;
	private String id;
	private String bookName;
	private Date regdate;
	private Date expiredate;
	
	
	
	public BookedBookDTO(int serialNumber, String id, String bookName, Date regdate, Date expiredate) {
		super();
		this.serialNumber = serialNumber;
		this.id = id;
		this.bookName = bookName;
		this.regdate = regdate;
		this.expiredate = expiredate;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}

	@Override
	public String toString() {
		return "BookedBookDTO [serialNumber=" + serialNumber + ", id=" + id + ", bookName=" + bookName + ", regdate="
				+ regdate + ", expiredate=" + expiredate + "]";
	}
	
	

}
