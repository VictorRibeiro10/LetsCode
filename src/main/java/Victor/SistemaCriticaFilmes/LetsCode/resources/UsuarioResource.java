package Victor.SistemaCriticaFilmes.LetsCode.resources;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Usuario;
import Victor.SistemaCriticaFilmes.LetsCode.repositores.UsuarioRepository;
import Victor.SistemaCriticaFilmes.LetsCode.services.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
		this.usuarioService.cadastrarUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
