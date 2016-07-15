package com.br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Mercadoria;
import com.br.model.to.MercadoriaTO;
import com.google.gson.Gson;

/**
 * Servlet implementation class mercadoriaController
 */
@WebServlet("/mercadoriaController")
public class mercadoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mercadoriaController() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoMercadoria = request.getParameter("tipo_mercadoria");
		String nomeMercadoria = request.getParameter("nome_mercadoria");
		String tipoNegocio = request.getParameter("tipo_negocio");
		
		Map<String,String> filtros = new HashMap<String,String>();
		filtros.put("tipo_mercadoria", tipoMercadoria);
		filtros.put("nome_mercadoria", nomeMercadoria);
		filtros.put("tipo_negocio", tipoNegocio);
		
		Mercadoria mercado = new Mercadoria();
		ArrayList<MercadoriaTO> mercadoriaTO = mercado.carregarFiltros(filtros);
		PrintWriter out = response.getWriter();
		String json = new Gson().toJson(mercadoriaTO);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF8-8");
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoMercadoria = request.getParameter("tipo_mercadoria");
		String nomeMercadoria = request.getParameter("nome_mercadoria");
		String tipoNegocio = request.getParameter("tipo_negocio");
		
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		Mercadoria mercadoria = new Mercadoria();
		MercadoriaTO mercadoriaTO = mercadoria.getMercadoriaTO();
		
		mercadoriaTO.setTipoMercadoria(tipoMercadoria);
		mercadoriaTO.setNomeMercadoria(nomeMercadoria);
		mercadoriaTO.setTipoNegocio(tipoNegocio);
		mercadoriaTO.setQuantidade(quantidade);
		mercadoriaTO.setPreco(preco);
		int iDMercadoria = mercadoria.cadastrarMercadoria(mercadoriaTO);
		
		mercadoriaTO.setiDMercadoria(iDMercadoria);
		
		PrintWriter out = response.getWriter();
		String json = new Gson().toJson(mercadoriaTO);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF8-8");
		out.print(json);
		
		
		
	}

}
