package daw2a.gestiondealimentos.repository;

import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.entities.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ExistenciasRepository extends JpaRepository<Existencias, Integer> {
    Optional<Existencias> findByAlimentoIdAndUbicacionId(int alimentoId, int ubicacionId);
    List<Existencias> findByAlimentoId(int alimentoId);
    List<Existencias> findByAlimentoIdOrderByFechaEntradaAsc(int alimentoId);


}
