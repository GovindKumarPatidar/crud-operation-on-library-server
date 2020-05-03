package com.genpact.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int bookId;
	
	@Column(name = "name")
	private String bookName;
	
	@Column(name = "author")
	private String bookAuthor;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "book_library_id", referencedColumnName = "id") private
	 * Library library;
	 */

	public Book() {
	}

	public Book(int bookId, String bookName, String bookAuthor/*, Library library*/) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		//this.library = library;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/*
	 * public Library getLibrary() { return library; }
	 * 
	 * 
	 * public void setLibrary(Library library) { this.library = library;
	 * library.getBooks().add(this); }
	 * 
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", library="
		/* + library */+ "]";
	}

}
