package daw2a.gestiondealimentos.repository;

import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.entities.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExistenciasRepository extends JpaRepository<Existencias, Integer> {
    List<Existencias> findByAlimentoIdAndUbicacionId(int alimentoId, int ubicacionId);
    List<Existencias> findByAlimentoId(int alimentoId);

}
