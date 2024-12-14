package daw2a.gestiondealimentos.services;

import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.repository.ExistenciasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExistenciasServices {
    private final ExistenciasRepository existenciasRepository;

    public Existencias save(Existencias existencias) {
        return existenciasRepository.save(existencias);
    }
    public List<Existencias> findAll() {
        return existenciasRepository.findAll();
    }
    public Optional<Existencias> findById(int id) {
        return existenciasRepository.findById(id);
    }
    public void deleteById(int id) {
        existenciasRepository.deleteById(id);
    }
}
