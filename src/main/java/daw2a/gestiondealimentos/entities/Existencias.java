package daw2a.gestiondealimentos.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Existencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "fecha_entrada", nullable = false)
    private LocalDate fechaEntrada;

    @ManyToOne
    @JoinColumn(name = "alimento_id", nullable = false)
    private Alimentos alimentos;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private Ubicaciones ubicaciones;
}
