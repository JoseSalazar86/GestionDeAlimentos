package daw2a.gestiondealimentos.controllers;
import daw2a.gestiondealimentos.entities.Alimentos;
import daw2a.gestiondealimentos.services.AlimentosServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alimentos")
@RequiredArgsConstructor
public class AlimentosControllers {
    private final AlimentosServices alimentosServices;

    @PostMapping
    public ResponseEntity<Alimentos> createAlimento(@RequestBody Alimentos alimentos) {
        return new ResponseEntity<>(alimentosServices.save(alimentos), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Alimentos> getAllAlimentos() {
        return alimentosServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimentos> getAlimentoById(@PathVariable int id) {
        return alimentosServices.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlimentoById(@PathVariable int id) {
        alimentosServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
