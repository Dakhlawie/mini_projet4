package com.meriem.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.meriem.demo.dto.FactureDTO;
import com.meriem.demo.entities.Client;
import com.meriem.demo.entities.Facture;


public interface FactureService {
	FactureDTO  saveFacture(Facture p);
	Facture updateFacture(Facture p);
	void deleteFacture(Facture p);
	 void deleteFactureById(Long id);
	 FactureDTO getFacture(Long id);
	List<FactureDTO> getAllFactures();
	Page<Facture> getAllFacturesParPage(int page, int size);
	List<Facture> findByClient (Client client);
	List<Facture> findByClientIdClient(Long id);
	 List<Client> getAllClients();
	 FactureDTO convertEntityToDto (Facture facture);
	 Facture convertDtoToEntity(FactureDTO factureDto);

}
