package grupo1.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import grupo1.backend.models.Voluntario;
import grupo1.backend.repositories.VoluntarioRepository;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public void addVoluntario(Voluntario voluntario) {
        voluntarioRepository.insert(voluntario);
    }

    public void updateVoluntario() {
    }

    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    public void getVoluntarioByNombre() {
    }

    public void deleteVoluntario() {
    }

}
