package guru.springboot.spring_boot_6.repositories;

import guru.springboot.spring_boot_6.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
