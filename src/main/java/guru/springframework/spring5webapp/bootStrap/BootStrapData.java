package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Books;
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
         Author nagesh = new Author("nagesh", "wankhade");
         Books java = new Books("Add on Java", "12345");

         authorRepository.save(nagesh);
         bookRepository.save(java);

         Author amey = new Author("amey", "wankhade");
         Books python = new Books("Add on Python", "54321");

         authorRepository.save(amey);
         bookRepository.save(python);

         Publisher publisher = new Publisher("XYZ","NAgpur","Nagpur","MH","4400554");

         publisherRepository.save(publisher);

         System.out.println("Started in BootStrap...");
         System.out.println("Number of Books:"+ bookRepository.count());
        System.out.println("Publisher Count :"+ publisherRepository.count());
     }
}
