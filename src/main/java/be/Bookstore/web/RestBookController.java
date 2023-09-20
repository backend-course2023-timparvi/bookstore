package be.Bookstore.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import be.Bookstore.domain.Book;
import be.Bookstore.domain.BookRepository;


@RestController
public class RestBookController {
	private static final Logger log = LoggerFactory.getLogger(RestBookController.class);
	
	@Autowired
	private BookRepository repository;
	
	//Return all books
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		log.info("//fetch and return all books");
		return repository.findAll();
	}
	
	//Return book by ID
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		log.info("//fetch and return a single title by ID");
		return repository.findById(bookId);
	}
}
