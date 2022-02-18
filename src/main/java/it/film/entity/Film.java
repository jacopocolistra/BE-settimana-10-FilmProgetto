package it.film.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="trovatutti", query="SELECT f FROM Film f")
@Entity
@Table(name = "film")
public class Film implements Serializable {private static final long serialVersionUID = 1L;
	
	//http://localhost:8080/film-0.0.1-SNAPSHOT/swagger-ui.html
	private int id;
	private int anno;
	private String titolo;
	private String regista;
	private String tipo;
	private String incasso;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	@Column(name="titolo")
	public String getTitolo() {return titolo;}
	
	public void setTitolo(String titolo) {this.titolo = titolo;}
	
	@Column(name="anno")
	public int getAnno() {return anno;}
	
	public void setAnno(int anno) {this.anno = anno;}
	
	@Column(name="regista")
	public String getRegista() {return regista;}
	
	public void setRegista(String regista) {this.regista = regista;}
	
	@Column(name="tipo")
	public String getTipo() {return tipo;}
	
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	@Column(name="incasso")
	public String getIncasso() {return incasso;}
	
	public void setIncasso(String incasso) {this.incasso = incasso;}}
	
	
	
