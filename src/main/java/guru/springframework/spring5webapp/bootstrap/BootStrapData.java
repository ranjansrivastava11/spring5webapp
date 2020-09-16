package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Orian");
        publisher.setCity("Gaon");
        publisher.setState("HY");
        publisherRepository.save(publisher);
        System.out.println("Publisher count "+publisherRepository.count());

        Author ran = new Author("Ranjan","Srivastava");
        Book ddd = new Book("Design Embedded","B21");
        ran.getBooks().add(ddd);
        ddd.getAuthors().add(ran);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(ran);
        bookRepository.save(ddd);


        Author sha = new Author("Shalini","Johari");
        Book eee = new Book("Devise Driver","C21");
        sha.getBooks().add(eee);
        eee.getAuthors().add(sha);
        publisher.getBooks().add(eee);
        authorRepository.save(sha);
        bookRepository.save(eee);

        System.out.println("Started in Boostap");

        publisherRepository.save(publisher);

        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Publisher Number of book" + publisher.getBooks().size());
    }
}
