package com.prmorais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.prmorais.model.Grupo;
import com.prmorais.repository.Grupos;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter{

	@Inject
	private Grupos grupos;

	
	/*public ProdutoConverter() { 
		 produtos = CDIServiceLocator.getBean(Produtos.class); 
	}*/
	 

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Grupo retorno = null;

		if (StringUtils.isNotBlank(value)) {
			Long id = new Long(value);
			retorno = grupos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Grupo grupo = (Grupo) value;
			return grupo.getId() == null ? null : grupo.getId().toString();
		
		}
		/*Produto produto = (Produto) value;
		if(value instanceof Produto){
			
			return produto.getId() == null ? null : produto.getId().toString();
		}*/

		return "";
	}

}
