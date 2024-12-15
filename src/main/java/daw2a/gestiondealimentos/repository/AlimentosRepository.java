package daw2a.gestiondealimentos.repository;

import daw2a.gestiondealimentos.entities.Alimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AlimentosRepository extends JpaRepository<Alimentos,Integer> {
    List<Alimentos> findByNombreContainingIgnoreCase(String nombre);
    @Query("SELECT a FROM Alimentos a WHERE a.fechaCaducidad IS NOT NULL AND a.fechaCaducidad <= :fechaLimite")
    List<Alimentos> findAlimentosCercanosACaducar(@Param("fechaLimite") LocalDate fechaLimite);
}
