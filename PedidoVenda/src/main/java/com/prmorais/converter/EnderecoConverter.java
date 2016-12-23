package com.prmorais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.prmorais.model.Endereco;
import com.prmorais.repository.Enderecos;

@FacesConverter(forClass = Endereco.class)
public class EnderecoConverter implements Converter{

	@Inject
	private Enderecos enderecos;

	
	/*public ProdutoConverter() { 
		 produtos = CDIServiceLocator.getBean(Produtos.class); 
	}*/
	 

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Endereco retorno = null;

		if (StringUtils.isNotBlank(value)) {
			Long id = new Long(value);
			retorno = enderecos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Endereco endereco = (Endereco) value;
			return endereco.getId() == null ? null : endereco.getId().toString();
		
		}
		/*Produto produto = (Produto) value;
		if(value instanceof Produto){
			
			return produto.getId() == null ? null : produto.getId().toString();
		}*/

		return "";
	}

}
