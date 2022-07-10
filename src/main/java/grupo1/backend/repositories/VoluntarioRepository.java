package grupo1.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import grupo1.backend.models.Voluntario;

public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {

}
