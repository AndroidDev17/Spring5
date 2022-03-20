package ankit.springframework.spring5webapp.bootStrap;

import ankit.springframework.spring5webapp.domain.Author;
import ankit.springframework.spring5webapp.domain.Book;
import ankit.springframework.spring5webapp.domain.Publisher;
import ankit.springframework.spring5webapp.repositories.AuthorRepository;
import ankit.springframework.spring5webapp.repositories.BookRepository;
import ankit.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private BookRepository mBookRepository;
    private AuthorRepository mAuthorRepository;
    private PublisherRepository mPublisherRepository;

    public DataInitializer(BookRepository mBookRepository,
                           AuthorRepository mAuthorRepository,
                           PublisherRepository mPublisherRepository) {
        this.mBookRepository = mBookRepository;
        this.mAuthorRepository = mAuthorRepository;
        this.mPublisherRepository = mPublisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher OReally = new Publisher("OReally","220965","USA","Ohao");
        mPublisherRepository.save(OReally);
        System.out.println("publisher count : "+mPublisherRepository.count());

        Author johnVlissides = new Author("John","Vlissides");
        Author ralphJohnson = new Author("Ralph","Johnson");

        Book GangOfFour = new Book("Gang of four","1000231");

        johnVlissides.getBooks().add(GangOfFour);
        ralphJohnson.getBooks().add(GangOfFour);

        GangOfFour.getAuthors().add(ralphJohnson);
        GangOfFour.getAuthors().add(johnVlissides);

        GangOfFour.setPublisher(OReally);
        OReally.getBooks().add(GangOfFour);

        mAuthorRepository.save(johnVlissides);
        mAuthorRepository.save(ralphJohnson);
        mBookRepository.save(GangOfFour);
        mPublisherRepository.save(OReally);

        Book aLostAge = new Book("A Lost Age","1000233");
        aLostAge.getAuthors().add(ralphJohnson);
        ralphJohnson.getBooks().add(aLostAge);
        aLostAge.setPublisher(OReally);
        OReally.getBooks().add(aLostAge);

        mBookRepository.save(aLostAge);
        mAuthorRepository.save(johnVlissides);
        mAuthorRepository.save(ralphJohnson);
        mPublisherRepository.save(OReally);

        System.out.println("Books : "+mBookRepository.count());
        System.out.println("authors : "+mAuthorRepository.count());

    }
}
