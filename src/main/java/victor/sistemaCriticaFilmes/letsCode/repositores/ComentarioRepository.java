package victor.sistemaCriticaFilmes.letsCode.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;

@Repository
public interface ComentarioRepository extends CrudRepository<ComentarioFilme, Long> {
	
	@Query("select c from ComentarioFilme c where c.idFilme = ?1")
	List<ComentarioFilme> findComentariosByIdFilme(String idFilme);
	
}
