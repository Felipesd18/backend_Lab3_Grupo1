package grupo1.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo1.backend.models.Voluntario;
import grupo1.backend.service.VoluntarioService;

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

    public void updateVoluntario() {
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> getAllVoluntario() {
        return ResponseEntity.ok(voluntarioService.getAllVoluntario());
    }

    public void getVoluntarioByNombre() {
    }

    public void deleteVoluntario() {
    }

}
