package org.transport.TP.Transport;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.transport.TP.Transport.*;

@Entity
@Table(name = "CARGAISON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_carg", discriminatorType = DiscriminatorType.STRING, length=2)

public abstract  class Cargaison implements Serializable {
	@Id
	@Column(name = "Ref_carg")
	private String ref;
	@Column(name = "distance")
	private double distance;
    @Column(name = "datelivraison")
	@Temporal(TemporalType.DATE)
	private Date datelivraison;
    //FetchType.LAZY indique que l'entité sera récupérée à la demande.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargaison")
	private Set<Marchandise> marchandise = new HashSet<Marchandise>();
	
	public Set<Marchandise> getMarchandise() {
		return marchandise;
	}

	public void setMarchandise(Set<Marchandise> marchandise) {
		this.marchandise = marchandise;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Date getDatelivraison() {
		return datelivraison;
	}

	public void setDatelivraison(Date datelivraison) {
		this.datelivraison = datelivraison;
	}

	public Cargaison(String ref, double distance, Date datelivraison) {
		super();
		this.ref = ref;
		this.distance = distance;
		this.datelivraison = datelivraison;
	}

	public Cargaison() {
		super();
		// TODO Auto-generated constructor stub
	}

}
