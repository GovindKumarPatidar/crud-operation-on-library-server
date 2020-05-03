package com.genpact.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int libId;
	
	@Column(name = "name")
	private String libName;
	
	@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "lb_fk",referencedColumnName = "id")
	private List<Book> books;

	public Library() {
	}

	public Library(int libId, String libName, List<Book> books) {
		super();
		this.libId = libId;
		this.libName = libName;
		this.books = books;
	}

	public int getLibId() {
		return libId;
	}

	public void setLibId(int libId) {
		this.libId = libId;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [libId=" + libId + ", libName=" + libName + ", books=" + books + "]";
	}

}
