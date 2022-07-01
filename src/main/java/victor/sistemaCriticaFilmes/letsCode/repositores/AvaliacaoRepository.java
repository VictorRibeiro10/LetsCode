package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.AvaliacaoFilme;

@Repository
public interface AvaliacaoRepository extends CrudRepository<AvaliacaoFilme, Long> {
	AvaliacaoFilme findByIdFilme(String idFilme);
}
