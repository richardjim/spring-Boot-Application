package guru.springboot.spring_boot_6.bootrap;

import guru.springboot.spring_boot_6.domain.Author;
import guru.springboot.spring_boot_6.domain.Book;
import guru.springboot.spring_boot_6.domain.Publisher;
import guru.springboot.spring_boot_6.repositories.AuthorRepository;
import guru.springboot.spring_boot_6.repositories.BookRepository;
import guru.springboot.spring_boot_6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book book_name = new Book();
        book_name.setTitle("Book worm");
        book_name.setIsbn("234");

        Author EricRespository = authorRepository.save(eric);
        Book bookSave = bookRepository.save(book_name);

        Author esther = new Author();
        esther.setFirstName("Esther");
        esther.setLastName("Felix");

        Book red = new Book();
        red.setTitle("Red Waybill");
        red.setIsbn("23456");

        Author EstherRespository = authorRepository.save(esther);
        Book redSave = bookRepository.save(red);

        Publisher publisher = new Publisher();
        publisher.setPublisher_name("Neol");
        publisher.setPublisher_address("lagos");
        Publisher savedPublisher = publisherRepository.save(publisher);

        redSave.setPublisher(savedPublisher);
        bookSave.setPublisher(savedPublisher);

        // Add books to authors
        EricRespository.getBooks().add(bookSave);
        EstherRespository.getBooks().add(redSave);

        // Save the updated authors
        authorRepository.save(EricRespository);
        authorRepository.save(EstherRespository);
        bookRepository.save(bookSave);
        bookRepository.save(redSave);

        // Print the number of books associated with each author
        System.out.println("Eric's books: " + EricRespository.getBooks().size());
        System.out.println("Esther's books: " + EstherRespository.getBooks().size());

        // Print the total number of authors and books in the repository
        System.out.println("Total authors: " + authorRepository.count());
        System.out.println("Total books: " + bookRepository.count());
        System.out.println("Total publishers: " + publisherRepository.count());
    }


}
