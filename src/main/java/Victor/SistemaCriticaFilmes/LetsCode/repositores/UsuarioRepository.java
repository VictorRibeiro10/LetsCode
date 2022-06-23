package Victor.SistemaCriticaFilmes.LetsCode.repositores;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
