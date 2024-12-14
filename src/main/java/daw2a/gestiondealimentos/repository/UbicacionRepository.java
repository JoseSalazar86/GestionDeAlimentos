package daw2a.gestiondealimentos.repository;

import daw2a.gestiondealimentos.entities.Existencias;
import daw2a.gestiondealimentos.entities.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbicacionRepository extends JpaRepository< Ubicaciones,Integer> {
    List<Ubicaciones> findByTipoUbicacion(String tipoUbicacion);
}
