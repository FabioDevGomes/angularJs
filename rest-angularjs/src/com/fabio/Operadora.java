package com.fabio;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONObject;

@XmlRootElement
public class Operadora {

	@XmlElement(name="nome")
	private String nome;
	@XmlElement(name="codigo")
	private Integer codigo;
	@XmlElement(name="categoria")
	private String categoria;
	@XmlElement(name="preco")
	private Double preco;
	
	public Operadora() {
		super();
	}

	public Operadora(String nome, Integer codigo, String categoria, Double preço) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.preco = preço;
	}
	
	@Override
	public String toString() {
		return new JSONObject().put("nome", nome).put("codigo", codigo).put("categoria", categoria).put("preco", preco).toString();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preço) {
		this.preco = preço;
	}
	
	
	
	
}
