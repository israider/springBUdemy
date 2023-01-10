package mx.com.gm.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "Persona")
public class Persona implements Serializable{
	private static final long serialVersionUID = -4577040013486122940L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String cnombre;
	
	@NotEmpty
	private String capellidop;
	
	@NotEmpty
	private String capellidom;
	
	@NotEmpty
	@Email
	private String cemail;
	
	private String ctel;
}
