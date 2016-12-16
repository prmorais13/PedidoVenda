package com.prmorais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.prmorais.model.Produto;
import com.prmorais.repository.Produtos;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	@Inject
	private Produtos produtos;

	/*
	 * public ProdutoConverter() { produtos =
	 * CDIServiceLocator.getBean(Produtos.class); }
	 */

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = produtos.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}

		return "";
	}

}
