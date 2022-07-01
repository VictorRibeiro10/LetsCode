package victor.sistemaCriticaFilmes.letsCode.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_perfil")
@Data
public class Perfil{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;
    
    private String nomePerfil;
    
    private String descricao;
}
