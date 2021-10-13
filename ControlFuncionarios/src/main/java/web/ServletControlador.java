package web;

import dados.Conexao;
import dados.FuncionarioDaoJDBC;
import dominio.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao != null) {
            switch (acao) {
                case "editar":
                    this.editarFuncionario(request, response);
                    break;
                case "eliminar":
                    this.eliminarFuncionario(request, response);
                    break;
                default:
                    this.acaoDefault(request, response);
            }
        } else {
            this.acaoDefault(request, response);
        }
    }

    private void acaoDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Funcionario> funcionarios = new FuncionarioDaoJDBC().listar();
        System.out.println("funcionarios = " + funcionarios);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("funcionarios", funcionarios);

        response.sendRedirect("funcionarios.jsp");
    }

    private void editarFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
        Funcionario funcionario = new FuncionarioDaoJDBC().encontrar(new Funcionario(idFuncionario));
        request.setAttribute("funcionario", funcionario);
        String jspEditar = "/WEB-INF/paginas/funcionario/editarFuncionario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao != null) {
            switch (acao) {
                case "inserir":
                    this.inserirFuncionario(request, response);
                    break;
                case "modificar":
                    this.modificarFuncionario(request, response);
                    break;
                default:
                    this.acaoDefault(request, response);
            }
        } else {
            this.acaoDefault(request, response);
        }
    }

    private void inserirFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String comida = request.getParameter("comida");

        Funcionario funcionario = new Funcionario(nome, cpf, comida);

        int registrosModificados = new FuncionarioDaoJDBC().inserir(funcionario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.acaoDefault(request, response);
    }

    private void modificarFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String comida = request.getParameter("comida");

        Funcionario funcionario = new Funcionario(idFuncionario, nome, cpf, comida);

        int registrosModificados = new FuncionarioDaoJDBC().atualizar(funcionario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.acaoDefault(request, response);
    }
    
        private void eliminarFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
     
        Funcionario funcionario = new Funcionario(idFuncionario);

        int registrosModificados = new FuncionarioDaoJDBC().eliminar(funcionario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.acaoDefault(request, response);
    }

}
