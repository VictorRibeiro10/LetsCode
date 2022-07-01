package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.RespostaComentario;

@Repository
public interface RespostaComentarioRepository extends CrudRepository<RespostaComentario, Long>{

}
