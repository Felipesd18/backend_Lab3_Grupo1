package grupo1.backend.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import grupo1.backend.models.Voluntario;

public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {

    @Query("{'nombre': ?0}")
    Optional<Voluntario> findByNombre(String nombre);

}
