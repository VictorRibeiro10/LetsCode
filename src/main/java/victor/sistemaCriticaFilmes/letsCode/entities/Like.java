package victor.sistemaCriticaFilmes.letsCode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_like")
@Data
public class Like {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLike;
	
	@ManyToOne
	@JoinColumn(name = "id_comentario_filme")
	private ComentarioFilme comentario;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private Boolean gostei;

}
