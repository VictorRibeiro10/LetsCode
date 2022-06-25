package victor.sistemaCriticaFilmes.letsCode.services;

import org.springframework.stereotype.Service;

import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
	
	
}
