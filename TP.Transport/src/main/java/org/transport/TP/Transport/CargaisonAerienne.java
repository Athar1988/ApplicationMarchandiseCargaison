package org.transport.TP.Transport;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CargaisonAerienne")
@PrimaryKeyJoinColumn(name = "Ref_carg")
@AttributeOverrides({
    @AttributeOverride(name="distance", column=@Column(name="distance")),
    @AttributeOverride(name="datelivraison", column=@Column(name="datelivraison"))
    })
public class CargaisonAerienne extends Cargaison {
	@Column(name = "poidMax")
	private double poidMax;

	public CargaisonAerienne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CargaisonAerienne(String ref, double distance, Date datelivraison, double max) {
		super(ref, distance, datelivraison);
		this.poidMax = max;
	}

	public double getPoidMax() {
		return poidMax;
	}

	public void setPoidMax(double poidMax) {
		this.poidMax = poidMax;
	}
}
