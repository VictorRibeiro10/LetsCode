package victor.sistemaCriticaFilmes.letsCode.repositores;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.Like;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
	Like findByUsuarioAndComentario(Usuario usuario, ComentarioFilme comentario);
	
	 @Transactional
		@Modifying
		@Query("delete from Like c WHERE c.comentario.idComentarioFilme = ?1" )
		void deleteLikes(Long idComentario);
}
