package com.meriem.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.meriem.demo.entities.Client;
import com.meriem.demo.entities.Facture;
@RepositoryRestResource(path = "rest")
public interface FactureRepository extends JpaRepository<Facture,Long>{
	@Query("select f from Facture f where f.client = ?1")
	List<Facture> findByClient (Client client);
	List<Facture> findByClientIdClient(Long id);
	


}
