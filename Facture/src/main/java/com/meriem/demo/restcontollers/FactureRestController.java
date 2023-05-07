package com.meriem.demo.restcontollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meriem.demo.dto.FactureDTO;
import com.meriem.demo.entities.Facture;
import com.meriem.demo.services.FactureService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FactureRestController {
	@Autowired
	FactureService factureService;
	@RequestMapping(method = RequestMethod.GET)
	public List<FactureDTO> getAllFactures() {
	return factureService.getAllFactures();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public FactureDTO getFactureById(@PathVariable("id") Long id) {
	return factureService.getFacture(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public FactureDTO createFacture(@RequestBody Facture facture) {
	return factureService.saveFacture(facture);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Facture updateFacture(@RequestBody Facture facture) {
	return factureService.updateFacture(facture);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
	factureService.deleteFactureById(id);
	}
	@RequestMapping(value="/factsclient/{idClient}",method = RequestMethod.GET)
	public List<Facture> getFacturesByCatId(@PathVariable("idClient") Long idClient) {
	return factureService.findByClientIdClient(idClient);
	}





}
