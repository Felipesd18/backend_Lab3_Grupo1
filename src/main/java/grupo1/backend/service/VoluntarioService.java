package grupo1.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import grupo1.backend.controller.VolunatarioController;
import grupo1.backend.models.Voluntario;
import grupo1.backend.repositories.VoluntarioRepository;
import grupo1.backend.models.Habilidad;
import grupo1.backend.repositories.HabilidadRepository;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    
    private final HabilidadRepository habilidadRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository, HabilidadRepository habilidadRepository) {
        this.voluntarioRepository = voluntarioRepository;
        this.habilidadRepository = habilidadRepository;
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
        savedVoluntario.setHabilidades(voluntario.getHabilidades());

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

    public Voluntario agregarHabilidad(String idV,String idH){

        Voluntario savedVoluntario = voluntarioRepository.findById(idV)
        .orElseThrow(() -> new RuntimeException(
                String.format("No se pudo encontrar un Voluntario por el id %s", idV)));
        
        Habilidad savedHabilidad = habilidadRepository.findById((idH)).orElseThrow(() -> new RuntimeException(
                String.format("No se pudo encontrar un Voluntario por el id %s",idH)));                
        ArrayList<Habilidad> nuevasHabilidades= savedVoluntario.getHabilidades();  
        nuevasHabilidades.add(savedHabilidad);               
        savedVoluntario.setHabilidades(nuevasHabilidades);
        voluntarioRepository.save(savedVoluntario);
        return savedVoluntario;
    }
}
