package com.meriem.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
private Date dateEmission;
	@NotNull
	@Min(value = 10)
	 @Max(value = 10000)

	private Double montant;
	@ManyToOne
	private Client client;
	public Facture() {
		super();
		
	}
	public Facture(Date dateEmission, Double montant) {
		super();
		this.dateEmission = dateEmission;
		this.montant = montant;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", dateEmission=" + dateEmission + ", montant=" + montant + "]";
	}
	
	

}
