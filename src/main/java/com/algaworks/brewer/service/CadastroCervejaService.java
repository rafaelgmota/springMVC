package com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired 
	private Cervejas cervejas;
	
	@Transactional //At JPA config the default transaction was disabled, so is necessary to tell where the transaction need to be enabled
	public void salvar(Cerveja cerveja)
	{
		cervejas.save(cerveja);
	}
}
