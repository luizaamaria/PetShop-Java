import java.util.Scanner;

public class Menu {
    Scanner scanner;
    private static Login login = Login.getInstance();

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void menuGerente() {
        Gerente usuarioLogado = (Gerente) login.getUsuarioLogado();
        String matricula;
        while(true) {
            exibeMenuGerente();
            String opcao = scanner.next();
            if(opcao.equals("1")) {
                String nome = getDadoMenu("Nome");
                matricula = getDadoMenu("Matricula");
                String senha = getDadoMenu("Senha");
                usuarioLogado.cadastraVendedor(nome, matricula, senha);
            }else if(opcao.equals("2")) {
                matricula = getDadoMenu("Matricula");
                usuarioLogado.removeUsuario(matricula);
            }else if(opcao.equals("3")) {
                usuarioLogado.gerarRelatorio();
            }else if(opcao.equals("4")) {
                matricula = getDadoMenu("Matricula");
                usuarioLogado.gerarRelatorioIndividual(matricula);
            }else if(opcao.equals("5")) {
                login.setUsuarioLogado(null);
                break;
            }else {
                System.out.println("Opção inválida. Digite uma nova opção.");
            }
        }
    }

    public void menuVendedor() {
        Vendedor usuarioLogado = (Vendedor) login.getUsuarioLogado();
        String matricula = usuarioLogado.getMatricula();
        while(true) {
            exibeMenuVendedor();
            String opcao = scanner.next();
            if(opcao.equals("1")) {
                double valor = getValorMenu();
                String formaPagamento = getDadoMenu("Forma Pagamento");
                usuarioLogado.realizaVenda(valor, formaPagamento, matricula);
            }else if(opcao.equals("2")) {
                usuarioLogado.gerarRelatorio();
            }else if(opcao.equals("3")) {
                login.setUsuarioLogado(null);
                break;
            }else {
                System.out.println("Opção inválida. Digite uma nova opção.");
            }
        }
    }

    public String getDadoMenu(String dado) {
        System.out.println("+-----------------------------+");
        System.out.println(String.format("+ %s ------------------+", dado));
        return scanner.next();
    }

    public double getValorMenu() {
        System.out.println("+-----------------------------+");
        System.out.println("+ Valor ----------------------+");
        return scanner.nextDouble();
    }


    public void exibeBoasVindas() {
        System.out.println("===============================");
        System.out.println("+  Bem-vindo ao JAVA PETSHOP  +");
        System.out.println("+-----------------------------+");
    }

    public void exibeMenuGerente() {
        System.out.println("===============================");
        System.out.println("+-- Escolha uma das opções  --+");
        System.out.println("+-----------------------------+");
        System.out.println("+ 1 - Cadastra vendedor ------+");
        System.out.println("+ 2 - Remove vendedor --------+");
        System.out.println("+ 3 - Relatorio de vendas ----+");
        System.out.println("+ 4 - Relatorio de v. ind ----+");
        System.out.println("+ 5 - Logout -----------------+");
        System.out.println("===============================");
    }

    public void exibeMenuVendedor() {
        System.out.println("===============================");
        System.out.println("+-- Escolha uma das opções  --+");
        System.out.println("+-----------------------------+");
        System.out.println("+ 1 - Realizar venda ---------+");
        System.out.println("+ 2 - Relatorio de vendas ----+");
        System.out.println("+ 3 - Logout -----------------+");
        System.out.println("===============================");
    }
}