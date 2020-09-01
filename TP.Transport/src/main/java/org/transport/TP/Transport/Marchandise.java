package org.transport.TP.Transport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "MARCHANDISE")
public class Marchandise implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarchandise;
	@Column(name = "nomMarchandise")
	private String nomMarchandise;
	@Column(name = "poidMarchandise")
	private double poidMarchandise;
	@Column(name = "volumeMarchandise")
	private double volumeMarchandise;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ref_carg")
	private Cargaison cargaison;

	public Cargaison getCargaison() {
		return cargaison;
	}
	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}
	public Marchandise() {
		super();
	}
	public Marchandise(String nomMarchandise, double poidMarchandise, double volumeMarchandise) {
		super();
		this.nomMarchandise = nomMarchandise;
		this.poidMarchandise = poidMarchandise;
		this.volumeMarchandise = volumeMarchandise;
	}
	public Long getIdMarchandise() {
		return idMarchandise;
	}
	public void setIdMarchandise(Long idMarchandise) {
		this.idMarchandise = idMarchandise;
	}
	public String getNomMarchandise() {
		return nomMarchandise;
	}
	public void setNomMarchandise(String nomMarchandise) {
		this.nomMarchandise = nomMarchandise;
	}
	public double getPoidMarchandise() {
		return poidMarchandise;
	}

	public void setPoidMarchandise(double poidMarchandise) {
		this.poidMarchandise = poidMarchandise;
	}

	public double getVolumeMarchandise() {
		return volumeMarchandise;
	}
	public void setVolumeMarchandise(double volumeMarchandise) {
		this.volumeMarchandise = volumeMarchandise;
	}
}
