package com.prmorais.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@Named
@RequestScoped
public class GraficoPedidosCriadosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LineChartModel model;
	
	public void preRender(){
		this.model = new LineChartModel();
		this.model.setTitle("Pedidos criados");
		this.model.setLegendPosition("e");
		this.model.setAnimate(true);
		
		adicionarSerie("Todos os pedidos");
		adicionarSerie("Meus pedidos");
	}

	private void adicionarSerie(String rotulo) {
		
		ChartSeries series = new ChartSeries(rotulo);
		
		series.set("1", Math.random() * 1000);
		series.set("2", Math.random() * 1000);
		series.set("3", Math.random() * 1000);
		series.set("4", Math.random() * 1000);
		series.set("5", Math.random() * 1000);
		
		this.model.addSeries(series);
	}

	public LineChartModel getModel() {
		return model;
	}

}
