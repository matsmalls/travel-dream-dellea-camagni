package travelDream.ejb.eaos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import travelDream.ejb.model.*;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column (nullable = false)
	private String userId;
	
	@Column (nullable = false)
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String email;

	@ElementCollection(targetClass = Group.class)
	@CollectionTable(name = "USER_GROUP", joinColumns = @JoinColumn(name = "userId"))
	@Enumerated(EnumType.STRING)
	@Column(name = "groupId")
	private List<Group> groups;

	
	public User() {
		super();
	}
	
	public User (UserDTO user){
		this.email = user.getEmail();
		this.cognome = user.getCognome();
		this.nome = user.getNome();
		this.userId = user.getUserId();
		this.password = user.getPassword();
		
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	public String getUserId(){
		return this.userId;
	}

}