package com.meriem.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriem.demo.entities.Client;
import com.meriem.demo.repos.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> getAllClients() {
		
		return clientRepository.findAll();
	}

}
