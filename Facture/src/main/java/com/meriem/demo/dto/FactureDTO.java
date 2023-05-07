package com.meriem.demo.dto;

import java.util.Date;

import com.meriem.demo.entities.Client;
import lombok.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureDTO {
private Long idFacture;

private Double montant;
private Date dateEmission;
private Client client;
}

