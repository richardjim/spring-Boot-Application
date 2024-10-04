package guru.springboot.spring_boot_6.repositories;

import guru.springboot.spring_boot_6.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
