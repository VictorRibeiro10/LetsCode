package Victor.SistemaCriticaFilmes.LetsCode.services;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Usuario;
import Victor.SistemaCriticaFilmes.LetsCode.repositores.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(Usuario usuario){
this.usuarioRepository.save(usuario);
    }
}
