package com.prmorais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.prmorais.model.Usuario;
import com.prmorais.repository.Usuarios;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{

	@Inject
	private Usuarios usuarios;

	
	/*public ProdutoConverter() { 
		 produtos = CDIServiceLocator.getBean(Produtos.class); 
	}*/
	 

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Usuario retorno = null;

		if (StringUtils.isNotBlank(value)) {
			Long id = new Long(value);
			retorno = usuarios.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Usuario usuario = (Usuario) value;
			return usuario.getId() == null ? null : usuario.getId().toString();
		
		}
		/*Produto produto = (Produto) value;
		if(value instanceof Produto){
			
			return produto.getId() == null ? null : produto.getId().toString();
		}*/

		return "";
	}

}
