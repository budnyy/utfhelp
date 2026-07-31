package utfhelp.backend.dtos.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalRequestDTO {
    private String nome;
    private String descricao;
    private Integer coord_x;
    private Integer coord_y;
    private Integer coord_z;
    private Long andar_id;
    private Long categoria_id;
}
