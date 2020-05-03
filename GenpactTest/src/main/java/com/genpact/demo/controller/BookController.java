package com.genpact.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.demo.entity.Book;
import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.service.BookService;

@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {
	@Autowired
	BookService bookservice;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> bookList = bookservice.getAllBook();
		return new ResponseEntity<List<Book>>(bookList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("library/{libId}")
	public ResponseEntity<List<Book>> getBookByLibraryId(@PathVariable int libId) throws RecordNotFoundException {
		List<Book> bookList = bookservice.getBooksByLibId(libId);
		return new ResponseEntity<List<Book>>(bookList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) throws RecordNotFoundException {
		Book book = bookservice.getBookById(id);
		return new ResponseEntity<Book>(book, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws RecordNotFoundException {
		Book newBook = bookservice.createBook(book);
		return new ResponseEntity<Book>(newBook, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("edit")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws RecordNotFoundException {
		Book updatedBook = bookservice.editBook(book);
		return new ResponseEntity<Book>(updatedBook, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public HttpStatus deleteBookById(@PathVariable("id") int id) throws RecordNotFoundException {
		bookservice.deleteBookById(id);
		return HttpStatus.OK;
	}
}
