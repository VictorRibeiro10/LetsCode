package Victor.SistemaCriticaFilmes.LetsCode.services;

import Victor.SistemaCriticaFilmes.LetsCode.entities.Perfil;
import Victor.SistemaCriticaFilmes.LetsCode.repositores.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;


    public void idPerfil(Perfil perfil){
        this.perfilRepository.save(perfil);
    }

}
