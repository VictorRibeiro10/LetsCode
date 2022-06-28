package victor.sistemaCriticaFilmes.letsCode.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final RestTemplate restTemplate;

	@Value("${api.url}")
	private String url;

	@Value("${api.key}")
	private String apiKey;

	public FilmeDTO buscarFilmePeloTitulo(String titulo) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> entity = new HttpEntity<>(headers);

		String uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("apikey", apiKey).queryParam("t", titulo)
				.toUriString();

		return restTemplate.exchange(uri, HttpMethod.GET, entity, FilmeDTO.class).getBody();

	}
}
