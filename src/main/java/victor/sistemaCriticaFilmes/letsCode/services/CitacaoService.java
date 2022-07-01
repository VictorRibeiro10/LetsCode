package victor.sistemaCriticaFilmes.letsCode.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.entities.CitacaoComentario;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.repositores.CitacaoComentarioRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class CitacaoService {
	
	private final PontoService pontoService;
	private final CitacaoComentarioRepository citacaoComentarioRepository;
	private final UsuarioRepository usuarioRepository;

	public void citarComentario(Long idComentario) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		ComentarioFilme comentarioFilme = new ComentarioFilme();
		comentarioFilme.setIdComentarioFilme(idComentario);
		
		CitacaoComentario citacaoComentario = new CitacaoComentario();
		citacaoComentario.setComentario(comentarioFilme);
		citacaoComentario.setUsuario(usuario);
		
		citacaoComentarioRepository.save(citacaoComentario);
		pontoService.incrementarPontuacaoUsuario(1L, usuario);
	}
	
	public void removerCitacaoComentario(Long idComentario) {
		citacaoComentarioRepository.deleteCitacoesComentario(idComentario);
	}
}
