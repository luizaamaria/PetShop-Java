public final class Login {

    private static Login instance;
    private static Menu menus = new Menu();
    private static Usuarios usuarios = Usuarios.getInstance();
    private Usuario usuarioLogado;

    public void exibeLogin() {
        while(true) {
            menus.exibeBoasVindas();
            String matricula = menus.getDadoMenu("Matricula");
            String senha = menus.getDadoMenu("Senha");
            boolean retornoLogin = this.realizaLogin(matricula, senha);
            if(retornoLogin) {
                if(this.usuarioLogado.getTipo().equals("Gerente")) {
                    menus.menuGerente();
                }else if(this.usuarioLogado.getTipo().equals("Vendedor")) {
                    menus.menuVendedor();
                }
            }
        }
    }

    public boolean realizaLogin(String matricula, String senha) {

        Usuario usuario = usuarios.checkCredenciais(matricula, senha);

        if(usuario != null) {
            this.usuarioLogado = usuario;
            System.out.println("Login realizado com sucesso!!!");
            return true;
        }
        System.out.println("Credenciais inválidas");
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