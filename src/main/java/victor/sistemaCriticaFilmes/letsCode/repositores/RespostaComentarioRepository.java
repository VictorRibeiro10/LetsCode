package victor.sistemaCriticaFilmes.letsCode.repositores;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.RespostaComentario;

@Repository
public interface RespostaComentarioRepository extends CrudRepository<RespostaComentario, Long> {

	@Transactional
	@Modifying
	@Query("delete from RespostaComentario c WHERE c.comentario.idComentarioFilme = ?1")
	void deleteRespostasComentario(Long idComentario);
}
