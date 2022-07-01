package victor.sistemaCriticaFilmes.letsCode.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tb_comentario")
@Data
public class comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;
    private Boolean gostou;
    private String resposta;
    private Long idUsuario;
    //gostou, resposta, excluir, repetido, idUsuario, Idfilme, descriçaoComentario
}
