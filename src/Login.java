import java.util.Scanner;

public final class Login {

    private static Login instance;
    private Usuario usuarioLogado;
    public Usuarios usuarios = Usuarios.getInstance();
    Scanner scanner = new Scanner(System.in);


    public void exibeLogin() {
        while(true) {
            System.out.println("===============================");
            System.out.println("Bem vindo ao PetShop!");
            System.out.println("===============================");
            System.out.println("Digite sua matrícula: ");
            String matricula = scanner.next();
            System.out.println("Digite sua senha: ");
            String senha = scanner.next();

            realizaLogin(matricula, senha);
        }
    }

    public boolean realizaLogin(String matricula, String senha) {
         Usuario usuario = usuarios.checkCredenciais(matricula, senha);
         if (usuario != null) {
             this.usuarioLogado = usuario;
             System.out.println("Login realizado com sucesso!");
             return true;
         }
         System.out.println("Usuário ou senha incorretos!");
         return false;
    }
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
}
