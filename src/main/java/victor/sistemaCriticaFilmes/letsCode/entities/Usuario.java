package victor.sistemaCriticaFilmes.letsCode.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(unique = true)
	private String username;

	private String password;

	@ManyToMany
	@JoinTable(
			  name = "tb_usuario_perfil", 
			  joinColumns = @JoinColumn(name = "id_usuario"), 
			  inverseJoinColumns = @JoinColumn(name = "id_perfil"))
	private Set<Perfil> perfils;
	

}
