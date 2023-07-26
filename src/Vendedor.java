public class Vendedor extends Usuario implements IUsuario{

    public static Vendas vendas = Vendas.getInstance();

    public Vendedor(String nome, String matricula, String senha) {
        super(nome, matricula, senha,  "Vendedor");
    }

    public void realizaVenda(double valor, String formaPagamento, String matricula) {
        vendas.realizaVenda(valor, formaPagamento, matricula);
    }

    @Override
    public void gerarRelatorio() {
        vendas.gerarRelatorioIndividual(this.getMatricula());
    }

}