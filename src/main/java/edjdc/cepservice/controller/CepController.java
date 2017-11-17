package edjdc.cepservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edjdc.cepservice.model.CepDTO;
import edjdc.cepservice.service.CepService;

@Controller
public class CepController {
	
	private static final Logger logger = LoggerFactory.getLogger(CepController.class);
	
	@Autowired
	private CepService cepService;

	@GetMapping
	public String index() {
		return "index";
	}
	
	@Cacheable(value = "cep-list")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/cep/{numero}")
	public @ResponseBody CepDTO cep(@PathVariable String numero) {
		logger.info("request cep", numero);
		return cepService.getCepDTO(numero);
	}
}
