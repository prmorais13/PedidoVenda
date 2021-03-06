package com.prmorais.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.prmorais.model.Pedido;
import com.prmorais.repository.Pedidos;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{

	@Inject
	private Pedidos pedidos;

	
	/*public ProdutoConverter() { 
		 produtos = CDIServiceLocator.getBean(Produtos.class); 
	}*/
	 

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Pedido retorno = null;

		if (StringUtils.isNotBlank(value)) {
			Long id = new Long(value);
			retorno = pedidos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pedido pedido = (Pedido) value;
			return pedido.getId() == null ? null : pedido.getId().toString();
		
		}
		/*Produto produto = (Produto) value;
		if(value instanceof Produto){
			
			return produto.getId() == null ? null : produto.getId().toString();
		}*/

		return "";
	}

}
