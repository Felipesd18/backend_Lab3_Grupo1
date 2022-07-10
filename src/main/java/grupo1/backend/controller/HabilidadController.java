package grupo1.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo1.backend.models.Habilidad;
import grupo1.backend.service.HabilidadService;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {

    private final HabilidadService habilidadService;

    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }

    @PostMapping
    public ResponseEntity addHabilidad(@RequestBody Habilidad habilidad) {
        habilidadService.addHabilidad(habilidad);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateHabilidad(@RequestBody Habilidad habilidad) {
        habilidadService.updateHabilidad(habilidad);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Habilidad>> getAllHabilidad() {
        return ResponseEntity.ok(habilidadService.getAllHabilidad());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Habilidad> getHabilidadByCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(habilidadService.getHabilidadByCodigo(codigo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHabilidad(@PathVariable String id) {
        habilidadService.deleteHabilidad(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
