package Victor.SistemaCriticaFilmes.LetsCode.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tb_perfil")
@Data
public class Perfil{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;
    
    private String nomePerfil;
    
    private String descricao;
}
