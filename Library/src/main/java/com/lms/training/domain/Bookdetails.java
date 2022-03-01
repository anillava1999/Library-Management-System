package com.lms.training.domain;

public class Bookdetails 
{
private String bookname;
private int isbn;
private String author;
private String publisher;
private int edition;
private int price;
private int quantity;

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public int getIsbn() {
	return isbn;
}

public void setIsbn(int isbn) {
	this.isbn = isbn;
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

public int getEdition() {
	return edition;
}

public void setEdition(int edition) {
	this.edition = edition;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
/*
public Bookdetails(String bookname, int isbn, String author, String publisher, int edition, int price, int quantity) {
	super();
	this.bookname = bookname;
	this.isbn = isbn;
	this.author = author;
	this.publisher = publisher;
	this.edition = edition;
	this.price = price;
	this.quantity = quantity;
}*/
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("BookDetails [book name=");
	builder.append(bookname);
	builder.append(", isbn=");
	builder.append(isbn);
	builder.append(", author=");
	builder.append(author);
	builder.append(", publisher=");
	builder.append(publisher);
	builder.append(", edition=");
	builder.append(edition);
	builder.append(", quantity=");
	builder.append(quantity);
	
	builder.append("]");
	return builder.toString();


}
}