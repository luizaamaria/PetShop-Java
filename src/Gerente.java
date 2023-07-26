public class Gerente extends Usuario {

    Usuarios usuarios;

    public Gerente(String nome, String matricula, String senha, String tipo) {
        super(nome, matricula, senha, "Gerente");
    }

    public void cadastrarVendedor(String nome, String matricula, String senha) {
        usuarios.adicionaUsuario(nome, matricula, senha, "Vendedor");
    }

    public void removeUsuario(String matricula) {
        usuarios.removeUsuario(matricula);

    }
}
