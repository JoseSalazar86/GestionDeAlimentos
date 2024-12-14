package daw2a.gestiondealimentos.repository;

import daw2a.gestiondealimentos.entities.Alimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimentos,Integer> {
    List<Alimentos> findByNombreContainingIgnoreCase(String nombre);
}
