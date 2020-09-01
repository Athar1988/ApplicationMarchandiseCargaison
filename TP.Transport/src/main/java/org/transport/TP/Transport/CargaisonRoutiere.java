package org.transport.TP.Transport;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "CargaisonRoutiere")
@PrimaryKeyJoinColumn(name = "Ref_carg")
@AttributeOverrides({
    @AttributeOverride(name="distance", column=@Column(name="distance")),
    @AttributeOverride(name="datelivraison", column=@Column(name="datelivraison"))
    })
public class CargaisonRoutiere extends Cargaison{
    @Column(name = "temperateur")

	private double temperateur;

	public double getTemperateur() {
		return temperateur;
	}

	public void setTemperateur(double temperateur) {
		this.temperateur = temperateur;
	}

	public CargaisonRoutiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargaisonRoutiere(String ref, double distance, Date datelivraison, double temp) {
		super(ref, distance, datelivraison);
		this.temperateur=temp;
	}
	
	

}
