package com.genpact.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.demo.entity.Book;
import com.genpact.demo.entity.Library;
import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.service.LibraryService;

@RestController
@RequestMapping("library")
@CrossOrigin
public class LibraryController {
	@Autowired
	LibraryService libraryService;

	@GetMapping
	public ResponseEntity<List<Library>> getAllLibrary() {
		List<Library> libraryList = libraryService.getAllLibrary();
		return new ResponseEntity<List<Library>>(libraryList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Library> addLibrary(@RequestBody Library library) throws RecordNotFoundException {
		Library newLibrary = libraryService.createLibrary(library);
		return new ResponseEntity<Library>(newLibrary, new HttpHeaders(), HttpStatus.OK);
	}
	
}
