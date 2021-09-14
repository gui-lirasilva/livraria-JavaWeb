package br.com.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.factory.ConnectionFactory;
import br.com.livraria.modelo.Autor;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {
	private AutorDao dao = new AutorDao((new ConnectionFactory()).getConnection());

	public AutoresServlet() {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String paramId = req.getParameter("id");
		String delId = req.getParameter("del");
		Integer id;
		
		if (paramId != null) {
			id = Integer.valueOf(paramId);
			req.setAttribute("mensagem", true);
			Autor autor = this.dao.buscaAutorPelaId(id);
			req.setAttribute("autor", autor);
		}

		if (delId != null) {
			id = Integer.valueOf(delId);
			this.dao.delete(id);
		}

		req.setAttribute("autores", this.dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		LocalDate dataNascimento = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String miniCurriculo = req.getParameter("miniCurriculo");
		Autor autor = new Autor(nome, dataNascimento, email, miniCurriculo);
		String paramId = req.getParameter("id");
		
		if (paramId != null) {
			Integer id = Integer.valueOf(paramId);
			this.dao.update(autor, id);
		} else {
			this.dao.cadastrar(autor);
		}

		res.sendRedirect("autores");
	}
}
