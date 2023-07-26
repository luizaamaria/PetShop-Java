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

            boolean retornoLogin = realizaLogin(matricula, senha);

            if(retornoLogin) {
                if(this.usuarioLogado.getTipo().equals("Gerente")) {
                    Gerente gerente = (Gerente) getUsuarioLogado();
                    while(true) {
                        System.out.println("===============================");
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Cadastrar vendedor");
                        System.out.println("2 - Remover vendedor");
                        System.out.println("3 - Logout");
                        System.out.println("===============================");

                        String opcao = scanner.next();
                        if(opcao.equals("1")) {
                            System.out.println("Digite o nome do vendedor: ");
                            String nomeCadastro = scanner.next();
                            System.out.println("Digite a matrícula do vendedor: ");
                            String matriculaCadastro = scanner.next();
                            System.out.println("Digite a senha do vendedor: ");
                            String senhaCadastro = scanner.next();
                            gerente.cadastrarVendedor(nomeCadastro, matriculaCadastro, senhaCadastro);
                        } else if(opcao.equals("2")) {
                            System.out.println("Digite a matrícula do vendedor: ");
                            matricula = scanner.next();
                            gerente.removeUsuario(matricula);
                        } else if(opcao.equals("3")) {
                            setUsuarioLogado(null);
                            break;
                        }else {
                            System.out.println("Opção inválida! Digite uma nova opção.");
                        }
                    }
                } else if (this.usuarioLogado.getTipo().equals("Vendedor")) {
                    while (true) {
                        System.out.println("===============================");
                        System.out.println("Escolha uma opção: ");
                        System.out.println("===============================");
                        System.out.println("1 - Logout");
                        System.out.println("===============================");
                        String opcao = scanner.next();
                        if(opcao.equals("1")) {
                            setUsuarioLogado(null);
                            break;
                        } else {
                            System.out.println("Opção inválida! Digite uma nova opção.");
                        }
                    }
                }
            }
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
