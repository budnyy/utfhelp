package utfhelp.backend.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "local")
public class Local {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private Integer coord_x;
    private Integer coord_y;
    private Integer coord_z;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "andar_id")
    private Andar andar;

    @OneToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Local(String nome,
                 String tipo,
                 Integer coord_x,
                 Integer coord_y,
                 Integer coord_z,
                 String descricao,
                 Andar andar){
        this.nome = nome;
        this.tipo = tipo;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.coord_z = coord_z;
        this.descricao = descricao;
        this.andar = andar;
    }
}
