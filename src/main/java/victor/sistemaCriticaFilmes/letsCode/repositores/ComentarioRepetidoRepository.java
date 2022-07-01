package victor.sistemaCriticaFilmes.letsCode.repositores;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioRepetido;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;

public interface ComentarioRepetidoRepository extends CrudRepository<ComentarioRepetido, Long> {
    ComentarioRepetido findByUsuarioAndComentario(Usuario usuario, ComentarioFilme comentario);
    
    @Transactional
	@Modifying
	@Query("delete from ComentarioRepetido c WHERE c.comentario.idComentarioFilme = ?1" )
	void deleteComentariosRepetidos(Long idComentario);
}
