package victor.sistemaCriticaFilmes.letsCode.services;

import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.entities.Perfil;
import victor.sistemaCriticaFilmes.letsCode.entities.Ponto;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.repositores.PerfilRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UpgradeService {
	
	private final PontoService pontoService;
	private final PerfilRepository perfilRepository;
	private final UsuarioRepository usuarioRepository;
	
	public void realizarUpgradeSePossivel() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		Ponto ponto = pontoService.findPontoByUsuario(usuario);
		
		if(ponto != null) {
			
			if(ponto.getPontos() == 20) {
				Perfil perfilBasico = perfilRepository.findByNomePerfil("BASICO");
				
				if(!jaPossuiPerfil(perfilBasico, usuario.getPerfils())) {
					usuario.getPerfils().add(perfilBasico);
				}
			}
			
			if(ponto.getPontos() == 100) {
				Perfil perfilAvancado = perfilRepository.findByNomePerfil("AVANCADO");
				
				if(!jaPossuiPerfil(perfilAvancado, usuario.getPerfils())) {
					usuario.getPerfils().add(perfilAvancado);
				}
			}
			
			if(ponto.getPontos() == 1000) {
				Perfil perfilModerador = perfilRepository.findByNomePerfil("MODERADOR");
				
				if(!jaPossuiPerfil(perfilModerador, usuario.getPerfils())) {
					usuario.getPerfils().add(perfilModerador);
				}
				
			}
			
			usuarioRepository.save(usuario);
		}
	
	}
	
	private boolean jaPossuiPerfil(Perfil perfil, Set<Perfil> perfils) {
		return perfils.stream().anyMatch(x -> x.getIdPerfil().equals(perfil.getIdPerfil()));
	}

}
