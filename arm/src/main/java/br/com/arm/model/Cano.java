package br.com.arm.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Cano extends Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String comprimento;
	private String espessura;
	private String normaTecnica;
	private String marca;

	public String getComprimento() {
		return comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public String getEspessura() {
		return espessura;
	}

	public void setEspessura(String espessura) {
		this.espessura = espessura;
	}

	public String getNormaTecnica() {
		return normaTecnica;
	}

	public void setNormaTecnica(String normaTecnica) {
		this.normaTecnica = normaTecnica;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
