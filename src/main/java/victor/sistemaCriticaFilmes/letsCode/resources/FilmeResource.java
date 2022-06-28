package victor.sistemaCriticaFilmes.letsCode.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;
import victor.sistemaCriticaFilmes.letsCode.services.FilmeService;

@RestController
@RequestMapping(path = "/filmes")
@RequiredArgsConstructor
public class FilmeResource {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<FilmeDTO> getFilme(@RequestParam("titulo") String titulo) {
      FilmeDTO filme = filmeService.buscarFilmePeloTitulo(titulo);
      return new ResponseEntity<>(filme, HttpStatus.OK);
    }
}
