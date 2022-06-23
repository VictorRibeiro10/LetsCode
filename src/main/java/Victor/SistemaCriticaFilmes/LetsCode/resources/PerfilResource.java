package Victor.SistemaCriticaFilmes.LetsCode.resources;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Perfil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilResource {
    public ResponseEntity<Perfil> idPerfil (@RequestBody Perfil perfil){
        return new ResponseEntity<>(perfil, HttpStatus.CREATED);
    }
}
