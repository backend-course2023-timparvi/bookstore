package be.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.Bookstore.domain.Book;
import be.Bookstore.domain.BookRepository;
import be.Bookstore.domain.Category;
import be.Bookstore.domain.CategoryRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save a few example titles");
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Romance"));
			
			brepository.save(new Book("Kuolinsoitto", "Anu Ojala", 2023, "9789512435883", 5.99, crepository.findByName("Thriller").get(0)));
			brepository.save(new Book("Vapahtaja", "Arttu Tuominen", 2023, "9789510478271", 5.99, crepository.findByName("Fiction").get(0)));
			
			log.info("fetch all books");
			for(Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
			
			};
		}
	}
