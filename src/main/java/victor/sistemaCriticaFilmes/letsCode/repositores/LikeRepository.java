package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.Like;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
	Like findByUsuarioAndComentario(Usuario usuario, ComentarioFilme comentario);
}
