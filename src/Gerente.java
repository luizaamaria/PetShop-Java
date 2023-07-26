public class Gerente extends Usuario{

    public static Vendas vendas = Vendas.getInstance();
    Usuarios usuarios;

    public Gerente(String nome, String matricula, String senha) {
        super(nome, matricula, senha, "Gerente");
        this.usuarios = Usuarios.getInstance();
    }

    public void cadastraVendedor(String nome, String matricula, String senha) {
        usuarios.adicionaUsuario(nome, matricula, senha, "Vendedor");
    }

    public void removeUsuario(String matricula) {
        usuarios.removeUsuario(matricula);
    }

    public void gerarRelatorioIndividual(String matricula) {
        vendas.gerarRelatorioIndividual(matricula);
    }

}