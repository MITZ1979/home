package entity;

import java.math.BigDecimal;

public class Book {
	private int id;
	private String bookName;
	private BigDecimal price;
	private String author;
	private String publisher;
	private String publishDate;
	
	public Book () {}
	
	public Book(String bookName, BigDecimal price, String author, String publisher, String publishDate) {
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}	

}
