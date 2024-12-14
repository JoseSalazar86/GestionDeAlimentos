package daw2a.gestiondealimentos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ubicaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 150)
    private String descripcion;

    @Column(nullable = false,length = 50)
    private String tipoUbicacion;

    private int capacidad;

    @OneToMany(mappedBy = "ubicacion", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Existencias> existencias;
}
