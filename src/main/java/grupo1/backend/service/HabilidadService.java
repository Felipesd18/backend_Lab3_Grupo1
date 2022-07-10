package grupo1.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import grupo1.backend.models.Habilidad;
import grupo1.backend.repositories.HabilidadRepository;

@Service
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;

    public HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    public void addHabilidad(Habilidad habilidad) {
        habilidadRepository.insert(habilidad);
    }

    public void updateHabilidad(Habilidad habilidad) {

        Habilidad savedHabilidad = habilidadRepository.findById(habilidad.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("No se pudo encontrar una Habilidad por el id %s", habilidad.getId())));

        savedHabilidad.setDescripcion(habilidad.getDescripcion());
        savedHabilidad.setCodigo(habilidad.getCodigo());

        habilidadRepository.save(habilidad);

    }

    public List<Habilidad> getAllHabilidad() {
        return habilidadRepository.findAll();
    }

    public Habilidad getHabilidadByCodigo(String codigo) {
        return habilidadRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException(
                String.format("No se puede lograr encontrar la habilidad por el codigo %s", codigo)));
    }

    public void deleteHabilidad(String id) {
        habilidadRepository.deleteById(id);
    }

}
