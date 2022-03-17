package co.edu.udea.practicafinal.repositories;

import co.edu.udea.practicafinal.entities.Researcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Researcher, String> {
}
