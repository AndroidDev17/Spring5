package ankit.springframework.spring5webapp.controllers;

import ankit.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository mBookRepository;

    public BookController(BookRepository mBookRepository) {
        this.mBookRepository = mBookRepository;
    }

    @RequestMapping("/books")
    public  String getBooks(Model model){
        model.addAttribute("books",mBookRepository.findAll());

        return "book/list";
    }
}
