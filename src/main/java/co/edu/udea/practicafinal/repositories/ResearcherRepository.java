package co.edu.udea.practicafinal.repositories;

import co.edu.udea.practicafinal.entities.Researcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResearcherRepository extends CrudRepository<Researcher, String> {
    Optional<Researcher> findByEmail(String email);
}
