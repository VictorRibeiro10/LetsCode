package Victor.SistemaCriticaFilmes.LetsCode.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tb_perfil")
public class Perfil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;
    @Column(name ="nomePerfil")
    private String nomePerfil;
    @Column(name ="descricao")
    private String descricao;
}
