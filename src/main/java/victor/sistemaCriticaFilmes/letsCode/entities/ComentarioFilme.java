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
@Table(name = "tb_comentario_filme")
@Data
public class ComentarioFilme {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentarioFilme;
	
	private String idFilme;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private String comentario;
	
	
}
