package daw2a.gestiondealimentos.controllers;

import daw2a.gestiondealimentos.entities.Ubicaciones;
import daw2a.gestiondealimentos.services.UbicacionesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
public class UbicacionesControllers {
    private final UbicacionesServices ubicacionesServices;

    @PostMapping
    public ResponseEntity<Ubicaciones> createUbicacion(@RequestBody Ubicaciones ubicaciones) {
        return new ResponseEntity<>(ubicacionesServices.save(ubicaciones), HttpStatus.CREATED);
    }
    @GetMapping
    private List<Ubicaciones> getAllUbicaciones() {
        return ubicacionesServices.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Ubicaciones> getUbicacionById(@PathVariable int id) {
        return ubicacionesServices.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUbicacionById(@PathVariable int id) {
        ubicacionesServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
