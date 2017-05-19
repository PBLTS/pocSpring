package br.edu.cruzeiro.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.edu.cruzeiro.model.PaginaModel;
import br.edu.cruzeiro.model.PaginaXmlModel;
import br.edu.cruzeiro.service.PocService;

@Controller
@RestController
@RequestMapping("/pocSpring")
public class PocController {
	
	
	@Autowired
	PocService pocService;
	
	@GetMapping("/pagina")
	public ModelAndView listar(){
		
		String nome = "UCS - POC Arquitetura Spring";
		
		ModelAndView mav = new ModelAndView("Pagina");
		mav.addObject("nome", nome);
		
		return mav;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaginaModel> rest_json(){
		return pocService.getDados();
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PaginaModel> rest_xml( @PathVariable(value = "id") String id ){
		return pocService.getDadosById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	public @ResponseBody PaginaXmlModel rest_xml(){

		PaginaXmlModel retorno = new PaginaXmlModel();
		retorno.setList(pocService.getDados());
		
		return retorno;
	}
	

}
