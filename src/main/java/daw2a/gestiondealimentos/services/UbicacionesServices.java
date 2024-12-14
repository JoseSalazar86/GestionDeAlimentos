package daw2a.gestiondealimentos.services;

import daw2a.gestiondealimentos.entities.Ubicaciones;
import daw2a.gestiondealimentos.repository.UbicacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UbicacionesServices {
    private final UbicacionRepository ubicacionRepository;

    public Ubicaciones save(Ubicaciones ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }
    public List<Ubicaciones> findAll() {
    return ubicacionRepository.findAll();
    }
    public Optional<Ubicaciones> findById(int id) {
        return ubicacionRepository.findById(id);
    }
    public void deleteById(int id) {
        ubicacionRepository.deleteById(id);
    }
}

