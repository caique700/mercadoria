<%@page import="com.br.model.Mercadoria"%>
<%@ include file="header.jsp"%>
<section class='container pesquisa-filtro'>
	<article class='row'>
		<header class='col-md-6 titulo-pesquisa'>
			<h1>Pesquise</h1>
			<h2>Sua Mercadoria</h2>
		</header>
		<div class='col-md-6 form-pesquisa'>
			<form id='pesquisa' method='POST'>
				<div class='form-group'>
					<input class='form-control' type='text' name='nome_mercadoria'
						placeholder="Digite o nome da mercadoria" />
				</div>
				<div class='form-group'>
					<select name='tipo_mercadoria' class='form-control'>
						<option value=''>Selecione Tipo</option>
						<c:forEach var="tipo_mercadoria" items="${tipoMercadorias}">
							<option value='${tipo_mercadoria}'>${tipo_mercadoria}</option>
						</c:forEach>
					</select>
				</div>
				<div class='form-group'>
					<select class='form-control' name='tipo_negocio'>
						<option value=''>Selecione Negocio</option>
						<option value='comprar'>Comprar</option>
						<option value='vender'>Venda</option>
					</select>
				</div>
				<input type="submit"  class='btn btn-custom'>
			</form>
		</div>


	</article>
</section>
<section class='pesquisa-grid container'>		
	<table class="table table-reflow" data-sort="table">
	      <thead class='table-inverse'>
	        <tr>
	        	<th class="header">#</th>
	          <th class="header">Nome</th>
	          <th class="header">Tipo</th>
	          <th class="header">Quantidade</th>
	          <th class="header">Preço</th>
	          <th class="header">Negocio</th>
	        </tr>
	      </thead>
	      <tbody id='dados-grid'>

	       </tbody>
    	</table>
	</section>


<div class='gif_ajax'>
	<div class=''>
		<img src='vendor/media/loading.gif'>
	</div>
</div>

<%@ include file="footer.jsp"%>