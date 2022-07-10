package grupo1.backend.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import grupo1.backend.models.Habilidad;

public interface HabilidadRepository extends MongoRepository<Habilidad, String> {

    @Query("{'codigo': ?0}")
    Optional<Habilidad> findByCodigo(String codigo);

}
