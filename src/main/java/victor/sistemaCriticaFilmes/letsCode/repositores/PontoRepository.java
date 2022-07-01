package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.Ponto;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;

@Repository
public interface PontoRepository extends CrudRepository<Ponto, Long> {
	Ponto findByUsuario(Usuario usuario);
}
