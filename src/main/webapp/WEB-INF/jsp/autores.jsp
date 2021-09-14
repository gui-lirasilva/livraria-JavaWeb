<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de autores</title>

<!-- Importação do Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

</head>
<body class="container">
	<div class="jumbotron">
		<h2 class="text-center">Cadastro de Autores</h2>
	</div>
	 <c:choose>
    <c:when test="${mensagem!=true}">
        <form action="<c:url value="/autores"/>" method="post">
			<div>
				<label>Nome</label>
				<input name="nome" class="form-control">
			</div>
			<div>
				<label>Email</label>
				<input name="email" class="form-control">
			</div>
			<div>
				<label>Data de Nascimento</label>
				<input name="data" class="form-control">
			</div>
			<div>
				<label>Mini curriculo</label>
				<textarea name="miniCurriculo" class="form-control"></textarea>
			</div>
			<p></p>
			<input type="submit" class="btn btn-success mb-3 mt-3" value="Cadastrar">
		</form>
        
    </c:when>    
    <c:otherwise>
        <form action="<c:url value="/autores"/>" method="post">
			<div>
				<label>Nome</label>
				<input name="nome" class="form-control" value="${autor.nome}">
			</div>
			<div>
				<label>Email</label>
				<input name="email" class="form-control" value="${autor.email}">
			</div>
			<div>
				<label>Data de Nascimento</label>
				<input name="data" class="form-control" value="${autor.dataNascimento}">
			</div>
			<div>
				<label>Mini curriculo</label>
				<textarea name="miniCurriculo" class="form-control">${autor.miniCurriculo}</textarea>
			</div>
			<input type="hidden" value="${autor.id}" name="id" />
			<input type="submit" class="btn btn-success mb-3 mt-3" value="Cadastrar">
		</form>
        
    </c:otherwise>
</c:choose>
		

	<div class="jumbotron">
		<h2 class="text-center">Lista de Autores</h2>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Data de Nascimento</th>
				<th>Ações</th>
			</tr>	
		</thead>
		<tbody>
		     
			<c:forEach items="${autores}" var="autor">
				<tr>
					<td>${autor.nome}</td>
					<td>${autor.email}</td>
					<td>${autor.dataNascimento}</td>
					<td>
						<a href="/livraria/autores?id=${autor.id}" class="btn btn-primary">Editar</a>
						<a href="/livraria/autores?del=${autor.id}" class="btn btn-danger">Excluir</a>
				</tr>
			</c:forEach>
		
		</tbody>	
	
	</table>
	
</body>
</html>