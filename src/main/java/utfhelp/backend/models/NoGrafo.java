package utfhelp.backend.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "no_grafo")
public class NoGrafo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Integer x;

    @Setter
    private Integer y;

    public NoGrafo(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
}
