package com.fabio;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONObject;

@XmlRootElement
public class Contato {

	@XmlElement(name="nome")
	private String nome;
	@XmlElement(name="telefone")
	private String telefone;
	@XmlElement(name="data")
	private Date data;
	@XmlElement(name="cor")
	private String cor;
	@XmlElement(name="operadora")
	private Operadora operadora;
	
	public Contato() {
		super();
	}

	public Contato(String nome, String telefone, Date data, String cor) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.data = data;
		this.cor = cor;
	}
	
	
	
	public Contato(String nome, String telefone, Date data, String cor, Operadora operadora) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.data = data;
		this.cor = cor;
		this.operadora = operadora;
	}

	@Override
	public String toString() {
		return new JSONObject().put("nome", nome).put("telefone", telefone).put("data", data).put("cor", cor).toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

}
