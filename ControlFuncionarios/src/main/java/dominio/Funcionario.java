package dominio;

public class Funcionario {
    
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String comida;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(String nome, String cpf, String comida) {
        this.nome = nome;
        this.cpf = cpf;
        this.comida = comida;
    }

    public Funcionario(int idFuncionario, String nome, String cpf, String comida) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.comida = comida;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", comida=" + comida + '}';
    }
    
}
