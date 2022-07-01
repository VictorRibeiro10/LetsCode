package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioRepetido;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;

public interface ComentarioRepetidoRepository extends CrudRepository<ComentarioRepetido, Long> {
    ComentarioRepetido findByUsuarioAndComentario(Usuario usuario, ComentarioFilme comentario);
}
