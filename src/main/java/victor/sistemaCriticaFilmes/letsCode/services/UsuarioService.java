package victor.sistemaCriticaFilmes.letsCode.services;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import victor.sistemaCriticaFilmes.letsCode.entities.Perfil;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.repositores.PerfilRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PerfilRepository perfilRepository;
	private final PasswordEncoder encoder;

	public void cadastrarUsuario(Usuario usuario) {
		
		usuario.setPassword(encoder.encode(usuario.getPassword()));

		Perfil perfilLeitor = perfilRepository.findByNomePerfil("LEITOR");

		if (usuario.getPerfils() == null || usuario.getPerfils().isEmpty()) {
			usuario.setPerfils(Set.of(perfilLeitor));
		}else if (!usuario.getPerfils().stream().anyMatch(x -> x.getIdPerfil().equals(perfilLeitor.getIdPerfil()))) {
			usuario.getPerfils().add(perfilLeitor);
		}
		
		this.usuarioRepository.save(usuario);
	}
	

}
