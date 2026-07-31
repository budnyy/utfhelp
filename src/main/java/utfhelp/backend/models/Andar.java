package utfhelp.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "andar")
public class Andar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private Integer num_andar;

    @Setter
    @OneToOne
    @JoinColumn(name = "bloco_id")
    private Bloco bloco;

    public Andar(Integer num_andar, Bloco bloco){
        this.num_andar = num_andar;
        this.bloco = bloco;
    }


}
