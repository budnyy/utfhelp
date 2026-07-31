package utfhelp.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "aresta_grafo")
public class ArestaGrafo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "no_a")
    private NoGrafo no_a;

    @Setter
    @ManyToOne
    @JoinColumn(name = "no_b")
    private NoGrafo no_b;

    @Setter
    @Column(nullable = false)
    private Integer distancia;

    public ArestaGrafo(NoGrafo no_a, NoGrafo no_b, Integer distancia){
        this.no_a = no_a;
        this.no_b = no_b;
        this.distancia = distancia;
    }
}
