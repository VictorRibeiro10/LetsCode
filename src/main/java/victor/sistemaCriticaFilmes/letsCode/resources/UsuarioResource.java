package victor.sistemaCriticaFilmes.letsCode.resources;

import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.services.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
		this.usuarioService.cadastrarUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
