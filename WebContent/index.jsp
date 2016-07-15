<%@ include file="header.jsp"%>
<section class='container'>
	<article class='row cadastro-index'>
		<div class="alert alert-success alert_custom" role="alert">
		
		</div>
		<header>
			<h1 class='title-index'>Cadastrar Mercadoria</h1>
		</header>

		<form id='cadastrar_mercadoria' action='' method='post'>
			<div class='col-md-6'>
				<div class='form-group'>
					<label>Tipo de Mercadoria</label> <input
						placeholder='digite o tipo da mercadoria' type='text'
						class='form-control' name='tipo_mercadoria' required>
				</div>
				<div class='form-group'>
					<label>Nome da Mercadoria</label> <input type='text'
						class='form-control' name='nome_mercadoria'
						placeholder='digite o nome da mercadoria' required>
				</div>
				<div class='form-group'>
					<label>Quantidade</label> <input type="number" class='form-control'
						name='quantidade' placeholder='coloque a quantidade' required>
				</div>
			</div>
			<div class='col-md-6'>
				<div class='form-group'>
					<label>Preço</label> <input type='text' class='form-control'
						id='preco' name='preco' placeholder='digite o preço da mercadoria'
						required>
				</div>
				<div class='form-group'>
					<label>Tipo de Negocio</label> <select class='form-control'
						name='tipo_negocio'>
						<option value='comprar'>Comprar</option>
						<option value='vender'>Vender</option>
					</select> <input type='submit' name='cadastrar_mercadoria'
						class='btn btn-custom'>
				</div>
			</div>

		</form>
	</article>
	<section class='dados-cadastro'>
		<p>Visualizar Mercadoria</p>
		<div class='angle-double'>
			
			<a class='' id='angle-fa' href='#'><i class="fa fa-angle-double-up" aria-hidden="true"></i></a>
		</div>
		<table class="cl" data-sort="table">
	      <thead>
	        <tr>
	          <th class="header">Nome</th>
	          <th class="header">Tipo</th>
	          <th class="header">Quantidade</th>
	          <th class="header">Preço</th>
	          <th class="header">Negocio</th>
	        </tr>
	      </thead>
	      <tbody>
	        <tr>
	          <td class='nome_mercadoria'></td>
	          <td class='tipo_mercadoria'></td>
	          <td class='quantidade'></td>
	          <td class='preco'></td>
	          <td class='tipo_negocio'></td>
	          <td class='excluir'><button ><i class="fa fa-times" aria-hidden="true"></i></button></td>
	        </tr>
	       </tbody>
    	</table>
	</section>
</section>

<div class='gif_ajax'>
	<div class=''>
		<img src='vendor/media/loading.gif'>
	</div>
</div>

<%@ include file="footer.jsp"%>

