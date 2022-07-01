package victor.sistemaCriticaFilmes.letsCode.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.dto.AvaliacaoFilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.entities.AvaliacaoFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.exceptions.BadAvaliacaoException;
import victor.sistemaCriticaFilmes.letsCode.exceptions.NotFoundException;
import victor.sistemaCriticaFilmes.letsCode.repositores.AvaliacaoRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class AvaliacaoFilmeService {

	private final AvaliacaoRepository avaliacaoRepository;
	private final UsuarioRepository usuarioRepository;
	private final FilmeService filmeService;
	private final PontoService pontoService;
	
	public void avaliarFilme(AvaliacaoFilmeDTO avaliacaoFilmeDTO) throws Exception {
		String idFilme = avaliacaoFilmeDTO.getIdFilme();
		Long avaliacao = avaliacaoFilmeDTO.getAvaliacao();
		
		FilmeDTO filme = filmeService.buscarFilmePeloId(idFilme);
		
		if(filme.getId() == null) {
			throw new NotFoundException("Filme com id " + idFilme + " não encontrado");
		}
		
		if(avaliacao == null || avaliacao < 0 || avaliacao > 10) {
			throw new BadAvaliacaoException("O valor da avaliação deve estar entre 0 e 10");
		}
		
		AvaliacaoFilme avaliacaoFilme = avaliacaoRepository.findByIdFilme(idFilme);
		
		if(avaliacaoFilme != null) {
			throw new BadAvaliacaoException("Você já avaliou esse filme");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		AvaliacaoFilme novaAvaliacaoFilme = new AvaliacaoFilme();
		novaAvaliacaoFilme.setAvaliacao(avaliacao);
		novaAvaliacaoFilme.setIdFilme(idFilme);
		novaAvaliacaoFilme.setUsuario(usuario);
		
		avaliacaoRepository.save(novaAvaliacaoFilme);
		pontoService.incrementarPontuacaoUsuario(1L, usuario);
	}
}
