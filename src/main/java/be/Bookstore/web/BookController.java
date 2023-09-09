package be.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.Bookstore.domain.Book;
import be.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@GetMapping("add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	@PostMapping("save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable Long id, Model model) {
		Optional<Book> bookOptional = repository.findById(id);
		model.addAttribute("book", bookOptional.get());
		return "editbook";
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book editedBook) {
		repository.save(editedBook);
		return "redirect:/booklist";
		}
}
