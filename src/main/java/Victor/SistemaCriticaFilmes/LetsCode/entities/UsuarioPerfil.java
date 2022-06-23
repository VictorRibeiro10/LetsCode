package Victor.SistemaCriticaFilmes.LetsCode.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tb_usuario_perfil")
public class UsuarioPerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPerfil;

}
