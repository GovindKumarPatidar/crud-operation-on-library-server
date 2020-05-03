
package com.genpact.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.genpact.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query(value = "select id,name,author from book where lb_fk=?1", nativeQuery = true)
	List<Book> getBookByLibraryId(int libId);
}
