package be.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		model.addAttribute("kirjat", repository.findAll());
		return "booklist";
	}
}
