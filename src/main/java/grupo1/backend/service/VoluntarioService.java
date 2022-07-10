package grupo1.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import grupo1.backend.controller.VolunatarioController;
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

    public void updateVoluntario(Voluntario voluntario) {

        Voluntario savedVoluntario = voluntarioRepository.findById(voluntario.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("No se pudo encontrar un Voluntario por el id %s", voluntario.getId())));

        savedVoluntario.setNombre(voluntario.getNombre());
        savedVoluntario.setCorreo(voluntario.getCorreo());
        savedVoluntario.setEdad(voluntario.getEdad());
        savedVoluntario.setLongitud(voluntario.getLongitud());
        savedVoluntario.setLatitud(voluntario.getLatitud());

        voluntarioRepository.save(voluntario);

    }

    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    public Voluntario getVoluntarioByNombre(String nombre) {
        return voluntarioRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException(
                String.format("No se puede lograr encontrar el voluntario por el nombre %s", nombre)));
    }

    public void deleteVoluntario(String id) {
        voluntarioRepository.deleteById(id);
    }

}
