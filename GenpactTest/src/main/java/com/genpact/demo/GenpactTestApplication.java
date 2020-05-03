package com.genpact.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.genpact.demo.entity.Book;
import com.genpact.demo.entity.Library;
import com.genpact.demo.repository.LibraryRepository;

@SpringBootApplication
public class GenpactTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenpactTestApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(LibraryRepository repository) {
		Book b1 = new Book(0,"The Man Who Counted", "Malba Tahan");
		Book b2 = new Book(0,"Zero", "Charles Seife");
		Book b3 = new Book(0,"History of PI", "Peter BeckMann");
		List<Book> books = new ArrayList<Book>();
		books.add(b1);books.add(b2);books.add(b3);
		Book b4 = new Book(0,"The Book as Arts", "Crystena Wasserman");
		Book b5 = new Book(0,"IKIGAI", "Hactor Garcia");
		List<Book> abooks = new ArrayList<Book>();
		abooks.add(b4);abooks.add(b5);
		Book b6 = new Book(0,"Go-Giver", "Bob Burg");
		List<Book> cbooks = new ArrayList<Book>();
		cbooks.add(b6);
	    return (args) -> {
	      repository.save(new Library(0,"Science",books));
	      repository.save(new Library(0,"Arts",abooks));
	      repository.save(new Library(0,"Commerce",cbooks));
	    };
	}
}
