package victor.sistemaCriticaFilmes.letsCode.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import victor.sistemaCriticaFilmes.letsCode.entities.Perfil;


@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long> {
	Perfil findByNomePerfil(String nomePerfil);
}
