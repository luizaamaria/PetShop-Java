import java.util.ArrayList;
import java.util.List;

public final class Usuarios {
    private static Usuarios instance;
    List<Usuario> usuarios;

    public Usuarios() {
        this.usuarios = new ArrayList<>();

    }

    public Usuario adicionaUsuario(String nome, String matricula, String senha, String tipo) {
        Usuario usuario;
        if(tipo.equals("Gerente")) {
            usuario = new Gerente(nome, matricula, senha);
            System.out.println("Gerente cadastrado com sucesso!");
        }else {
            usuario = new Vendedor(nome, matricula, senha);
            System.out.println("Vendedor cadastrado com sucesso!");
        }
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario checkCredenciais(String matricula, String senha){
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getMatricula().equals(matricula)) {
                if(usuarios.get(i).getSenha().equals(senha)) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }

    public int indexof(String matricula){
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public void removeUsuario(String matricula) {
        int indice = this.indexof(matricula);
        if(indice != -1) {
            usuarios.remove(indice);
            System.out.println("Usuário removido com sucesso");
        }else {
            System.out.println("Usuário não encontrado");
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static Usuarios getInstance() {
        if (instance == null) {
            instance = new Usuarios();

        }
        return instance;
    }

}