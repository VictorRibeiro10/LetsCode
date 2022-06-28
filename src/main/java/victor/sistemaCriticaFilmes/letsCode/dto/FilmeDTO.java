package victor.sistemaCriticaFilmes.letsCode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.io.Serializable;

@Data

public class FilmeDTO implements Serializable {
    private String title;
   @JsonProperty("imdbID")
    private String id;
}
