package br.edu.cruzeiro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.cruzeiro.model.PaginaModel;

@Service
public class PocService {
	
	
	public List<PaginaModel> getDados(){
		List<PaginaModel> dados = new ArrayList<PaginaModel>();
		for (int i = 0; i < 10; i++) {
			PaginaModel paginaModel = new PaginaModel();
			paginaModel.setId(String.valueOf(i));
			paginaModel.setNome("Nome Rest");
			
			dados.add(paginaModel);
		}
		return dados;
	}
	
	
	public List<PaginaModel> getDadosById(String pId){
		List<PaginaModel> dados = new ArrayList<PaginaModel>();
		for (int i = 0; i < 10; i++) {
			PaginaModel paginaModel = new PaginaModel();
			paginaModel.setId(String.valueOf(Integer.valueOf(pId)+i));
			paginaModel.setNome("Nome Rest");
			
			dados.add(paginaModel);
		}
		return dados;
	}

}
