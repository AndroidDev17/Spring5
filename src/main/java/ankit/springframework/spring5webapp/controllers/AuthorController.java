package ankit.springframework.spring5webapp.controllers;

import ankit.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository mAuthorRepository;

    public AuthorController(AuthorRepository mAuthorRepository) {
        this.mAuthorRepository = mAuthorRepository;
    }

    @RequestMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", mAuthorRepository.findAll());
        return "author/list";
    }
}
