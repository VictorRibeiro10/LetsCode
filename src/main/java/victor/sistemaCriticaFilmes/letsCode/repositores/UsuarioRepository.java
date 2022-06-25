package victor.sistemaCriticaFilmes.letsCode.repositores;

import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
