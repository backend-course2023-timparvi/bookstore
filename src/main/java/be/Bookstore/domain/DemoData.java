package be.Bookstore.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoData {

	@Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            Book kirja1 = new Book("Kuolinsoitto", "Anu Ojala", 2023, "9789512435883", 5.99);
            Book kirja2 = new Book("Vapahtaja", "Arttu Tuominen", 2023, "9789510478271", 7.99);
            
            repository.save(kirja1);
            repository.save(kirja2);
            
            System.out.println("Two demo books added to database");
            System.out.println(kirja1);
            System.out.println(kirja2);
            
        };
	}
}