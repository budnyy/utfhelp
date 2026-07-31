package utfhelp.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String mensagem;

    @Setter
    @Column(nullable = false)
    private String tipo;

    @Setter
    private Timestamp created_at;

    public Feedback(String mensagem, String tipo, Timestamp created_at){
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.created_at = created_at;
    }
}
