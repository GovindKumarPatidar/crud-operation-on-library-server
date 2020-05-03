package com.genpact.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.demo.entity.Book;
import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	 
	
	public List<Book> getAllBook() {
		List<Book> bookList = bookRepository.findAll();
		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<Book>();
		}
	}

	public List<Book> getBooksByLibId(int libId) throws RecordNotFoundException {
		 List<Book> list = bookRepository.getBookByLibraryId(libId);
		 System.out.println(list);
		 return list;
	}
	
	public Book getBookById(int id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("No book record found for given id:"+id);
		}
	}

	public Book createBook(Book book) throws RecordNotFoundException {
		Book newBook = bookRepository.save(book);
		return newBook;
	}
	
	public Book editBook(Book book) throws RecordNotFoundException {
		int bookId = book.getBookId();
		Optional<Book> bookObj = bookRepository.findById(bookId);
		if (bookObj.isPresent()) {
			bookRepository.save(book);
			return book;
		} else {
			throw new RecordNotFoundException("No book record found for given id: "+bookId);
		}
	}

	public void deleteBookById(int id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("Not able to delete, book record not exist for given id: "+id);
		}
	}
}
