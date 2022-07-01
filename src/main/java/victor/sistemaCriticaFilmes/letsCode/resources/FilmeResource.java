package victor.sistemaCriticaFilmes.letsCode.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.dto.AvaliacaoFilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.dto.ComentarioFilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.dto.RespostaComentarioDTO;
import victor.sistemaCriticaFilmes.letsCode.entities.ComentarioFilme;
import victor.sistemaCriticaFilmes.letsCode.services.AvaliacaoFilmeService;
import victor.sistemaCriticaFilmes.letsCode.services.CitacaoService;
import victor.sistemaCriticaFilmes.letsCode.services.ComentarioFilmeService;
import victor.sistemaCriticaFilmes.letsCode.services.FilmeService;
import victor.sistemaCriticaFilmes.letsCode.services.UpgradeService;

@RestController
@RequestMapping(path = "/filmes")
@RequiredArgsConstructor
public class FilmeResource {

	private final FilmeService filmeService;
	private final AvaliacaoFilmeService avaliacaoFilmeService;
	private final ComentarioFilmeService comentarioFilmeService;
	private final CitacaoService citacaoService;
	private final UpgradeService upgradeService;

	@GetMapping
	public ResponseEntity<FilmeDTO> getFilme(@RequestParam("titulo") String titulo) {
		FilmeDTO filme = filmeService.buscarFilmePeloTitulo(titulo);
		return new ResponseEntity<>(filme, HttpStatus.OK);
	}

	@PostMapping("/avaliacoes")
	public ResponseEntity<Void> avaliarFilme(@RequestBody AvaliacaoFilmeDTO avaliacaoFilmeDTO) throws Exception {
		avaliacaoFilmeService.avaliarFilme(avaliacaoFilmeDTO);
		upgradeService.realizarUpgradeSePossivel();
		return ResponseEntity.ok(null);
	}

	@PostMapping("/comentarios")
	public ResponseEntity<Void> comentarFilme(@RequestBody ComentarioFilmeDTO comentarioFilmeDTO) throws Exception {
		comentarioFilmeService.comentarFilme(comentarioFilmeDTO);
		upgradeService.realizarUpgradeSePossivel();
		return ResponseEntity.ok(null);
	}

	@GetMapping("/comentarios/{idFilme}")
	public ResponseEntity<List<ComentarioFilme>> getComentarios(@PathVariable String idFilme) {
		List<ComentarioFilme> comentarios = comentarioFilmeService.getComentarioDoFilmePorId(idFilme);
		return ResponseEntity.ok(comentarios);
	}

	@PostMapping("/comentarios/{idComentario}")
	public ResponseEntity<Void> comentarComentario(@PathVariable Long idComentario,
			@RequestBody RespostaComentarioDTO comentario) throws Exception {
		comentarioFilmeService.comentarComentario(idComentario, comentario.getComentario());
		upgradeService.realizarUpgradeSePossivel();
		return ResponseEntity.ok(null);
	}

	@PostMapping("/citacoes/comentario/{idComentario}")
	public ResponseEntity<Void> citarComentario(@PathVariable Long idComentario) {
		citacaoService.citarComentario(idComentario);
		upgradeService.realizarUpgradeSePossivel();
		return ResponseEntity.ok(null);
	}

	@PostMapping("/like/comentario/{idComentario}")
	public ResponseEntity<Void> likeComentario(@PathVariable Long idComentario, @RequestParam("like") Boolean like) {
		comentarioFilmeService.likeComentario(idComentario, like);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/repetido/comentario/{idComentario}")
	public ResponseEntity<Void> comentarioRepetido(@PathVariable Long idComentario, @RequestParam("repetido") Boolean repetido) {
		comentarioFilmeService.comentarioRepetido(idComentario, repetido);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/comentarios/{idComentario}")
	public ResponseEntity<Void> deletarComentario(@PathVariable Long idComentario) {
		comentarioFilmeService.deletarComentario(idComentario);
		return ResponseEntity.ok(null);
	}
}
