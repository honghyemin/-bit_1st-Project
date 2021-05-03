package kr.co.bit.library.main.dto;

public class BookDTO {
	
	private int serialNumber;
	private String callNumber;
	private String location;
	private String bookName;
	private String author;
	private String publisher;
	private int year;
	private double rating;
	private int checkCount;
	private int stock;
	
	
	
	public BookDTO() {
		super();
	}
	
	

	public BookDTO(int stock) {
		super();
		this.stock = stock;

	}
	
	public BookDTO(String bookName) {
		super();
		this.bookName = bookName;
	}
	



	public BookDTO(int serialNumber, String callNumber, String location, String bookName, String author,
			String publisher, int year) {
		super();
		this.serialNumber = serialNumber;
		this.callNumber = callNumber;
		this.location = location;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}
	
	public BookDTO(int serialNumber, String callNumber, String location, String bookName, String author,
			String publisher, int year, int stock) {
		super();
		this.serialNumber = serialNumber;
		this.callNumber = callNumber;
		this.location = location;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.stock = stock;
	}

	public BookDTO(int serialNumber, String callNumber, String location, String bookName, String author,
			String publisher, int year, double rating, int checkCount, int stock) {
		super();
		this.serialNumber = serialNumber;
		this.callNumber = callNumber;
		this.location = location;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.rating = rating;
		this.checkCount = checkCount;
		this.stock = stock;
	}
	
	
	
	public BookDTO(int serialNumber, String callNumber, String location, String bookName, String author,
			String publisher, int year, int checkCount, int stock) {
		super();
		this.serialNumber = serialNumber;
		this.callNumber = callNumber;
		this.location = location;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.year = year;

		this.checkCount = checkCount;
		this.stock = stock;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BookDTO [serialNumber=" + serialNumber + ", callNumber=" + callNumber + ", location=" + location
				+ ", bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + ", year=" + year
				+ ", rating=" + rating + ", checkCount=" + checkCount + ", stock=" + stock + "]";
	}
	
	
	
	

}
