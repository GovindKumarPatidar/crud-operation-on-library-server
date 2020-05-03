package com.genpact.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.demo.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{
}
