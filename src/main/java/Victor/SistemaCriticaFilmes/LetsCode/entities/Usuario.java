package Victor.SistemaCriticaFilmes.LetsCode.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    //@manytomany
    private List<Perfil> perfils;

    //id, username, passwprd, lista de perfil, nota filme
}
