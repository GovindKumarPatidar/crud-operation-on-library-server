package com.genpact.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.demo.entity.Book;
import com.genpact.demo.entity.Library;
import com.genpact.demo.exception.RecordNotFoundException;
import com.genpact.demo.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;

	public List<Library> getAllLibrary() {
		List<Library> libraryList = libraryRepository.findAll();
		if (libraryList.size() > 0) {
			return libraryList;
		} else {
			return new ArrayList<Library>();
		}
	}
	
	public Library createLibrary(Library library) throws RecordNotFoundException {
		Library newLibrary = libraryRepository.save(library);
		return newLibrary;
	}
}
