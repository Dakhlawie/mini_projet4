package com.meriem.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.meriem.demo.dto.FactureDTO;
import com.meriem.demo.entities.Client;
import com.meriem.demo.entities.Facture;
import com.meriem.demo.repos.ClientRepository;
import com.meriem.demo.repos.FactureRepository;
@Service
public class FactureServiceImpl implements FactureService{
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	ClientRepository clientRepository;

	@Override
	public FactureDTO saveFacture(Facture p) {
		
		return convertEntityToDto(factureRepository.save(p));
	}

	@Override
	public Facture updateFacture(Facture p) {
		
		return factureRepository.save(p);
	}

	@Override
	public void deleteFacture(Facture p) {
		factureRepository.delete(p);
		
	}

	@Override
	public void deleteFactureById(Long id) {
		factureRepository.deleteById(id);
		
	}

	@Override
	public FactureDTO getFacture(Long id) {
		
		return convertEntityToDto(factureRepository.findById(id).get());
	}

	@Override
	public List<FactureDTO> getAllFactures() {
		
		return factureRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public Page<Facture> getAllFacturesParPage(int page, int size) {
		
		return factureRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Facture> findByClient(Client client) {
		
		return factureRepository.findByClient(client);
	}

	@Override
	public List<Facture> findByClientIdClient(Long id) {
		
		return factureRepository.findByClientIdClient(id);
	}

	@Override
	public List<Client> getAllClients() {
		
		return clientRepository.findAll();
	}
	@Override
	public FactureDTO convertEntityToDto(Facture facture) {
		/*FactureDTO factureDTO = new FactureDTO();
	 factureDTO.setIdFacture(facture.getIdFacture());
     factureDTO.setMontant(facture.getMontant());
	 factureDTO.setDateEmission(f.getDateEmission());
	 factureDTO.setClient(facture.getClient()); 
	 return factureDTO; */
	 
	 return FactureDTO.builder()
	.idFacture(facture.getIdFacture())
	.dateEmission(facture.getDateEmission())
	.montant(facture.getMontant())
    .client(facture.getClient())
	.build();
	}
	@Override
	public Facture convertDtoToEntity(FactureDTO factureDto) {
	Facture facture = new Facture();
	facture.setIdFacture(factureDto.getIdFacture());

	facture.setMontant(factureDto.getMontant());
	facture.setDateEmission(factureDto.getDateEmission());
	facture.setClient(factureDto.getClient()); 
	 return facture; 
	}


}
