package daw2a.gestiondealimentos.services;

import daw2a.gestiondealimentos.entities.Alimentos;
import daw2a.gestiondealimentos.repository.AlimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AlimentosServices {
    private final AlimentoRepository alimentoRepository;

    public Alimentos save(Alimentos alimentos) {
        return alimentoRepository.save(alimentos);
    }

    public List<Alimentos> findAll() {
        return alimentoRepository.findAll();
    }
    public Optional<Alimentos> findById(int id) {
        return alimentoRepository.findById(id);
    }

    public void deleteById(int id) {
        alimentoRepository.deleteById(id);
    }
}

