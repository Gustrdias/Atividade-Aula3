package br.com.atividade3.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;

@Entity
@Table(name= "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator ="native")
	@GenericGenerator(name="native",strategy= "native")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="email")
	private String email;
	
	public Cliente() {
		
	}
	public Cliente(String name,String address,String email) {
		super();
		this.name=name;
		this.address=address;
		this.email=email;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
