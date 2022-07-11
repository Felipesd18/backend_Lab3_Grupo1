package grupo1.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo1.backend.models.Voluntario;
import grupo1.backend.service.VoluntarioService;

import grupo1.backend.models.Habilidad;
import grupo1.backend.service.HabilidadService;

@RestController
@RequestMapping("/voluntario")
public class VolunatarioController {

    private final VoluntarioService voluntarioService;

    public VolunatarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @PostMapping
    public ResponseEntity addVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioService.addVoluntario(voluntario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioService.updateVoluntario(voluntario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> getAllVoluntario() {
        return ResponseEntity.ok(voluntarioService.getAllVoluntario());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Voluntario> getVoluntarioByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(voluntarioService.getVoluntarioByNombre(nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVoluntario(@PathVariable String id) {
        voluntarioService.deleteVoluntario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{idV}/{idH}")
    public ResponseEntity addHablidad(@PathVariable String idV,@PathVariable String idH) {
        System.out.println(idV);
        System.out.println(idH);
        voluntarioService.agregarHabilidad(idV,idH);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
