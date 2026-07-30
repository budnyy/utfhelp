package utfhelp.backend.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArestaGrafoRequestDTO {
    private Long noA_id;
    private Long noB_id;
    private Integer distancia;
}
