

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProcessarFormulario
 */
@WebServlet("/processar")
public class ProcessarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		// Recuperar os parametrns
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String data = request.getParameter("dataNascimento");
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// Converte String para Data
		LocalDate date = LocalDate.parse(data,formatter);
		
		// int idade = Period.between(date, LocalDate.now()).getYears();
		
		// A classe Period.between calcula o valor de Ano, Mes e dia do perido desejado
		Period idade = Period.between(date, LocalDate.now());
			
		// Concatenar as strings
		String nomeCompleto = nome + " " + sobrenome;
		
		// preparar a resposta ao usuário
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Resposta</title></head>");
		out.println("<body><h1>Seu nome completo é: "+ nomeCompleto + "</h1>");
		// Com a função getYers (fução da classe Period) ele retorna apenas a idade que foi calculada em Period.betwenn
		out.println("<h2>Idade: " + idade.getYears() + "</h2>");
		out.println("</body></html>");
	}

}
