package victor.sistemaCriticaFilmes.letsCode.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import victor.sistemaCriticaFilmes.letsCode.dto.FilmeDTO;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FilmeService {
    private final RestTemplate restTemplate;

    public FilmeDTO buscarFilmePeloTitulo(String titulo) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper ob = new ObjectMapper();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "*/*");
        Map<String,Object> params = new HashMap<>();
        params.put("apikey","2a5e72f8");
        params.put("t",titulo);
       String response = restTemplate.exchange("http://www.omdbapi.com", HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),String.class,params).getBody();
       return ob.readValue(response, FilmeDTO.class);
    }
}
