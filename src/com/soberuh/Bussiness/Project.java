package com.soberuh.Bussiness;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
	private int id;
	private String nome;
	@Id
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
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
