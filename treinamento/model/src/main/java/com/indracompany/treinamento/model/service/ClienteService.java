package com.indracompany.treinamento.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.dto.ClienteDTO;
import com.indracompany.treinamento.model.entity.Cliente;
import com.indracompany.treinamento.model.repository.ClienteRepository;
import com.indracompany.treinamento.util.CpfUtil;

@Service
public class ClienteService extends GenericCrudService<Cliente, Long, ClienteRepository>{

	  public List<ClienteDTO> buscarClientePorNome(String nome)
	  { 
		   
		  
		  List<Cliente> clientes = repository.findByNomeStartingWith(nome);
		  
		  if (clientes == null || clientes.isEmpty()) {
			  throw new AplicacaoException(ExceptionValidacoes.ALERTA_NENHUM_REGISTRO_ENCONTRADO);
		  }
		  
		  List<ClienteDTO> retorno = new ArrayList<ClienteDTO>();
		  for (Cliente c: clientes) {
			  ClienteDTO dto = new ClienteDTO();
			  dto.setNome(c.getNome());
			  retorno.add(dto);
		  }
		  return retorno;
	  }
}
