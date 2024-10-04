package guru.springboot.spring_boot_6.repositories;

import guru.springboot.spring_boot_6.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
