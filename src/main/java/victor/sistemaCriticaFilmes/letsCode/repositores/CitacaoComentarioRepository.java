package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.CitacaoComentario;

@Repository
public interface CitacaoComentarioRepository extends CrudRepository<CitacaoComentario, Long> {

}
