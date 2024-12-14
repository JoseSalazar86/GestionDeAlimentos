package daw2a.gestiondealimentos.controllers;

import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.entities.Ubicaciones;
import daw2a.gestiondealimentos.services.ExistenciasServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/existencias")
@RequiredArgsConstructor
public class ExistenciasControllers {
    private final ExistenciasServices existenciasServices;

    @PostMapping
    public ResponseEntity<Existencias> createExistencias(@RequestBody Existencias existencia) {
        return new ResponseEntity<>(existenciasServices.save(existencia), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Existencias> getAllExistencias() {
        return existenciasServices.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Existencias> getExistenciaById(@PathVariable int id) {
        return existenciasServices.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExistenciaById(@PathVariable int id) {
        existenciasServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
