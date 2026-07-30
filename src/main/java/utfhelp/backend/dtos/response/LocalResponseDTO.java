package utfhelp.backend.dtos.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocalResponseDTO {

    @Setter(AccessLevel.NONE)
    private Long id;

    private String nome;
    private String tipo;
    private String descricao;
    private Long andar_id;
    private Long categoria_id;

    public LocalResponseDTO(String nome,
                            String tipo,
                            String descricao,
                            Long andar_id,
                            Long categoria_id){
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.andar_id = andar_id;
        this.categoria_id = categoria_id;
    }
}
