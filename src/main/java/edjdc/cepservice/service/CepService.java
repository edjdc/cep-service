package edjdc.cepservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edjdc.cepservice.model.CepDTO;

@Service
public class CepService {

	@Autowired
	private RestTemplate restTemplate;

	public CepDTO getCepDTO(String numero) {
		return restTemplate.getForObject("https://viacep.com.br/ws/{numero}/json", CepDTO.class, numero);
	}

}
