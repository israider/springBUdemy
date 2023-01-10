package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 2369585111590527039L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String pass;
	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Rol> roles;

}