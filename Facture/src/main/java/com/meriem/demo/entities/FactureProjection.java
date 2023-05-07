package com.meriem.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "montant", types = { Facture.class })
public interface FactureProjection {
	public String getMontant();

}
