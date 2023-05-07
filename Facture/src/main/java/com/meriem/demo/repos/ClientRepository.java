package com.meriem.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meriem.demo.entities.Client;
import com.meriem.demo.entities.Facture;



public interface ClientRepository extends JpaRepository<Client,Long>{
	List<Client> findByNom(String nom);
	List<Client> findByNomContains(String nom);
	@Query("select c from Client c where c.nom like %?1 and c.Adresse like %?2")
	List<Client> findByNomAdresse (String nom, String adresse);
	/*@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);*/
	List<Client> findByOrderByNomAsc();
	@Query("select c from Client c order by c.nom ASC, c.Adresse DESC")
	List<Client> trierClientsNomsAdresse ();

}
