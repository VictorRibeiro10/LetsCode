package Victor.SistemaCriticaFilmes.LetsCode.resources;


import Victor.SistemaCriticaFilmes.LetsCode.entities.Usuario;
import Victor.SistemaCriticaFilmes.LetsCode.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/new")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(HttpStatus.CREATED);

        //if (result.hasErrors()) {
        //    result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
         //   return ResponseEntity.badRequest().body(response);
    }

}
