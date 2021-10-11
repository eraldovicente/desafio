package dados;

import dominio.Funcionario;
import java.sql.*;
import java.util.*;

public class FuncionarioDaoJDBC {

    private static final String SQL_SELECT = "SELECT idFuncionario, nome, cpf, comida"
            + " FROM funcionario";

    private static final String SQL_SELECT_BY_ID = "SELECT idFuncionario, nome, cpf, comida"
            + " FROM funcionario WHERE idFuncionario = ?";

    private static final String SQL_INSERT = "INSERT INTO funcionario(nome, cpf, comida)"
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE funcionario "
            + " SET nome=?, cpf=?, comida=? WHERE idFuncionario=?";

    private static final String SQL_DELETE = "DELETE FROM funcionario WHERE idFuncionario = ?";

    public List<Funcionario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idFuncionario = rs.getInt("idFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String comida = rs.getString("comida");

                funcionario = new Funcionario(idFuncionario, nome, cpf, comida);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return funcionarios;
    }

    public Funcionario encontrar(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, funcionario.getIdFuncionario());
            rs = stmt.executeQuery();
            rs.absolute(1);

            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String comida = rs.getString("comida");

            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setComida(comida);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(rs);
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return funcionario;
    }

    public int inserir(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getComida());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;
    }

    public int atualizar(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getComida());
            stmt.setInt(4, funcionario.getIdFuncionario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;
    }

    public int eliminar(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, funcionario.getIdFuncionario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexao.close(stmt);
            Conexao.close(conn);
        }
        return rows;
    }

}
