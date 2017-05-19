package br.edu.cruzeiro.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class PaginaXmlModel {
	
	private List<PaginaModel> list;

	public List<PaginaModel> getList() {
		return list;
	}

	public void setList(List<PaginaModel> list) {
		this.list = list;
	}
	
	

}
