package victor.sistemaCriticaFilmes.letsCode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_citacao_comentario")
@Data
public class CitacaoComentario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCitacaoComentario;
	
	@ManyToOne
	@JoinColumn(name = "id_comentario_filme")
	private ComentarioFilme comentario;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
