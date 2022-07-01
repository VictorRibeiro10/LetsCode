package victor.sistemaCriticaFilmes.letsCode.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.dto.ComentarioFilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.entities.CitacaoComentario;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.entities.Like;
import victor.sistemaCriticaFilmes.letsCode.entities.RespostaComentario;
import victor.sistemaCriticaFilmes.letsCode.entities.Usuario;
import victor.sistemaCriticaFilmes.letsCode.exceptions.BadAvaliacaoException;
import victor.sistemaCriticaFilmes.letsCode.exceptions.NotFoundException;
import victor.sistemaCriticaFilmes.letsCode.repositores.CitacaoComentarioRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.ComentarioRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.LikeRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.RespostaComentarioRepository;
import victor.sistemaCriticaFilmes.letsCode.repositores.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class ComentarioFilmeService {

	private final ComentarioRepository comentarioRepository;
	private final RespostaComentarioRepository respostaComentarioRepository;
	private final FilmeService filmeService;
	private final UsuarioRepository usuarioRepository;
	private final PontoService pontoService;
	private final CitacaoComentarioRepository citacaoComentarioRepository;
	private final LikeRepository likeRepository;

	public void comentarFilme(ComentarioFilmeDTO comentarioFilmeDTO) throws Exception {
		String idFilme = comentarioFilmeDTO.getIdFilme();
		String comentario = comentarioFilmeDTO.getComentario();

		FilmeDTO filme = filmeService.buscarFilmePeloId(idFilme);

		if (filme.getId() == null) {
			throw new NotFoundException("Filme com id " + idFilme + " não encontrado");
		}

		if (StringUtils.isEmpty(comentario)) {
			throw new BadAvaliacaoException("O valor do comentario não pode ser nulo ou vazio");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		ComentarioFilme comentarioFilme = new ComentarioFilme();
		comentarioFilme.setComentario(comentario);
		comentarioFilme.setIdFilme(idFilme);
		comentarioFilme.setUsuario(usuario);
		
		comentarioRepository.save(comentarioFilme);
		pontoService.incrementarPontuacaoUsuario(1L, usuario);
		
	}
	
	public void comentarComentario(Long idComentario, String comentario) throws Exception {
		
		if (StringUtils.isEmpty(comentario)) {
			throw new BadAvaliacaoException("O valor do comentario não pode ser nulo ou vazio");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		ComentarioFilme comentarioEntity = new ComentarioFilme();
		comentarioEntity.setIdComentarioFilme(idComentario);
		
		RespostaComentario respostaComentario = new RespostaComentario();
		respostaComentario.setComentarioDescricao(comentario);
		respostaComentario.setUsuario(usuario);
		respostaComentario.setComentario(comentarioEntity);
		
		respostaComentarioRepository.save(respostaComentario);
		pontoService.incrementarPontuacaoUsuario(1L, usuario);
		
	}
	
	public void likeComentario(Long idComentario, Boolean like) {
		ComentarioFilme comentarioEntity = new ComentarioFilme();
		comentarioEntity.setIdComentarioFilme(idComentario);
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		Like likeExistente = likeRepository.findByUsuarioAndComentario(usuario, comentarioEntity);
		
		if(likeExistente != null) {
			likeExistente.setGostei(like);
		}else {
			likeExistente = new Like();
			likeExistente.setComentario(comentarioEntity);
			likeExistente.setUsuario(usuario);
			likeExistente.setGostei(like);
		}
		
		likeRepository.save(likeExistente);
	}
	
	
	public List<ComentarioFilme> getComentarioDoFilmePorId(String idFilme){
		return comentarioRepository.findComentariosByIdFilme(idFilme);
	}
	

}
