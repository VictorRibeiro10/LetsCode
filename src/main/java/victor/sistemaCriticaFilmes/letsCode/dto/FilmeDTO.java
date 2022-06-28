package victor.sistemaCriticaFilmes.letsCode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("imdbID")
	private String id;
	
	@JsonProperty("Title")
	private String titulo;
	
	@JsonProperty("Year")
	private String ano;
	
	@JsonProperty("Rated")
	private String classificacao;
	
	@JsonProperty("Released")
	private String lancamento;
	
	@JsonProperty("Runtime")
	private String tempoDuracao;
	
	@JsonProperty("Genre")
	private String genero;
	
	@JsonProperty("Director")
	private String diretor;
	
	@JsonProperty("Writer")
	private String escritor;
	
	@JsonProperty("Actors")
	private String atores;
	
	@JsonProperty("Plot")
	private String enredo;
	
	@JsonProperty("Language")
	private String linguagem;
	
	@JsonProperty("Country")
	private String pais;
	
	@JsonProperty("Awards")
	private String premios;
	
	@JsonProperty("Poster")
	private String poster;
	
	@JsonProperty("Ratings")
	private List<Rating> classificacoes;
	
	@JsonProperty("Metascore")
	private String metascore;
	
	@JsonProperty("imdbRating")
	private String avaliacaoImdb;
	
	@JsonProperty("imdbVotes")
	private String votosImdb;
	
	@JsonProperty("Type")
	private String tipo;
	
	@JsonProperty("DVD")
	private String dvd;
	
	@JsonProperty("BoxOffice")
	private String bilheteria;
		
	@JsonProperty("Production")
	private String producao;
	
	@JsonProperty("Website")
	private String webSite;
	
	@JsonProperty("Response")
	private String resposta;
	
	@Data
	public static class Rating{
		
		@JsonProperty("Source")
		private String fonte;
		
		@JsonProperty("Value")
		private String valor;
	}
	
}
