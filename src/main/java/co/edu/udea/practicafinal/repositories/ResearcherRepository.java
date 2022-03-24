package co.edu.udea.practicafinal.repositories;

import co.edu.udea.practicafinal.entities.Researcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Interfaz que servirá para mapear la entidad
 */
@Repository
public interface ResearcherRepository extends CrudRepository<Researcher, String> {
    /**
     * Metodo para buscar el correo del usuario
     * @param email
     * @return
     */
    Optional<Researcher> findByEmail(String email);
}
