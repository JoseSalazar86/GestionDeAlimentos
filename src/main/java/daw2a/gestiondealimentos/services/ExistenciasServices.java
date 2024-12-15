package daw2a.gestiondealimentos.services;

import daw2a.gestiondealimentos.entities.Alimentos;
import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.entities.Ubicaciones;
import daw2a.gestiondealimentos.repository.AlimentosRepository;
import daw2a.gestiondealimentos.repository.ExistenciasRepository;
import daw2a.gestiondealimentos.repository.UbicacionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    private final AlimentosRepository alimentoRepository;
    private final UbicacionRepository ubicacionRepository;

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
    public List<Existencias> obtenerExistenciasPorAlimentoOrdenadas(int alimentoId) {
        return existenciasRepository.findByAlimentoIdOrderByFechaEntradaAsc(alimentoId);
    }

    @Transactional
    public void moverAlimento(int alimentoId, int origenId, int destinoId, int cantidad) {
        // Validar que las ubicaciones y el alimento existen
        Ubicaciones origen = ubicacionRepository.findById(origenId)
                .orElseThrow(() -> new RuntimeException("Ubicación de origen no encontrada"));
        Ubicaciones destino = ubicacionRepository.findById(destinoId)
                .orElseThrow(() -> new RuntimeException("Ubicación de destino no encontrada"));
        Alimentos alimento = alimentoRepository.findById(alimentoId)
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        // Buscar existencia en el origen
        Existencias existenciaOrigen = existenciasRepository.findByAlimentoIdAndUbicacionId(alimentoId, origenId)
                .orElseThrow(() -> new RuntimeException("El alimento no está disponible en la ubicación de origen"));

        if (existenciaOrigen.getCantidad() < cantidad) {
            throw new RuntimeException("Cantidad insuficiente en la ubicación de origen");
        }

        // Actualizar existencia en el origen
        existenciaOrigen.setCantidad(existenciaOrigen.getCantidad() - cantidad);
        if (existenciaOrigen.getCantidad() == 0) {
            existenciasRepository.delete(existenciaOrigen); // Eliminar si queda en 0
        } else {
            existenciasRepository.save(existenciaOrigen);
        }

        // Buscar o crear existencia en el destino
        Existencias existenciaDestino = existenciasRepository.findByAlimentoIdAndUbicacionId(alimentoId, destinoId)
                .orElse(null);

        if (existenciaDestino == null) {
            existenciaDestino = new Existencias();
            existenciaDestino.setAlimentos(alimento);
            existenciaDestino.setUbicaciones(destino);
            existenciaDestino.setCantidad(cantidad);
            existenciaDestino.setFechaEntrada(LocalDate.now()); // Usar la fecha actual
        } else {
            existenciaDestino.setCantidad(existenciaDestino.getCantidad() + cantidad);
        }

        existenciasRepository.save(existenciaDestino);
    }

}
