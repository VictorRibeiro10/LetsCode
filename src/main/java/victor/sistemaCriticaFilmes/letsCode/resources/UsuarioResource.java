package victor.sistemaCriticaFilmes.letsCode.resources;

import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.services.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

	private final UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
		this.usuarioService.cadastrarUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}