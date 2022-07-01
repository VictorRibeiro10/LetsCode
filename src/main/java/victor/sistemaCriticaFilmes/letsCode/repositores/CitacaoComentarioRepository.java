package victor.sistemaCriticaFilmes.letsCode.repositores;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.CitacaoComentario;

@Repository
public interface CitacaoComentarioRepository extends CrudRepository<CitacaoComentario, Long> {
	
	@Transactional
	@Modifying
	@Query("delete from CitacaoComentario c WHERE c.comentario.idComentarioFilme = ?1" )
	void deleteCitacoesComentario(Long idComentario);

}
