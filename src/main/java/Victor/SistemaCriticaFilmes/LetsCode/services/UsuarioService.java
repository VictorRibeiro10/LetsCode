package Victor.SistemaCriticaFilmes.LetsCode.services;

import org.springframework.stereotype.Service;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Usuario;
import Victor.SistemaCriticaFilmes.LetsCode.repositores.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
	
	
}
