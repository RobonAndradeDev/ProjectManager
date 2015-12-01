package com.soberuh.Bussiness;


import javax.persistence.*;

@Entity
@Table(name="projeto")
public class Project {
	@Id
	@GeneratedValue
	@Column(name = "idprojeto")
	private Long id;
	private String nome;
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/*
	@OneToMany(mappedBy = "area", fetch = FetchType.EAGER)
	@JoinColumn(name = "areaID")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	*/
}
