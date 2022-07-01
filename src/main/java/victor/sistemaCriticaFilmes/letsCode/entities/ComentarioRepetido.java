package victor.sistemaCriticaFilmes.letsCode.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_repetido")
@Data
public class ComentarioRepetido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepetido;

    @ManyToOne
    @JoinColumn(name = "id_comentario_filme")
    private ComentarioFilme comentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private Boolean repetido;

}
