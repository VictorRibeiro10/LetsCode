package victor.sistemaCriticaFilmes.letsCode.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.entities.Ponto;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.repositores.PontoRepository;

@Service
@RequiredArgsConstructor
public class PontoService {

	private final PontoRepository pontoRepository;
	
	public void incrementarPontuacaoUsuario(Long numero, Usuario usuario) {
		Ponto ponto = pontoRepository.findByUsuario(usuario);
		
		if(ponto != null) {
			ponto.setPontos(ponto.getPontos() + numero);
		}else {
			ponto = new Ponto();
			ponto.setPontos(numero);
			ponto.setUsuario(usuario);
		}
		
		pontoRepository.save(ponto);
	}
	
	public Ponto findPontoByUsuario(Usuario usuario) {
		return pontoRepository.findByUsuario(usuario);
	}
	
}
