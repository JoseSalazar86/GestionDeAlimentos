package daw2a.gestiondealimentos.services;

import daw2a.gestiondealimentos.entities.Alimentos;
import daw2a.gestiondealimentos.repository.AlimentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlimentosServices {
    private final AlimentosRepository alimentoRepository;

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

    public List<Alimentos> obtenerAlimentosCercanosACaducar() {
        LocalDate fechaActual = LocalDate.now(); // Fecha actual
        return alimentoRepository.findAll().stream()
                .filter(alimento -> alimento.getFechaCaducidad() != null) // Filtrar alimentos con fecha válida
                .filter(alimento -> {
                    LocalDate fechaAlerta = alimento.getFechaCaducidad().minusDays(alimento.getDiasAlerta());
                    return !fechaAlerta.isAfter(fechaActual); // Si la fecha de alerta es anterior o igual a hoy
                })
                .collect(Collectors.toList());
    }
}

