import java.util.ArrayList;
import java.util.List;

public final class Vendas {
    private static Vendas instance;
    List<Venda> vendas;

    public Vendas() {
        this.vendas = new ArrayList<>();
        realizaVenda(300.00, "Crédito", "man123");
        realizaVenda(200.00, "Débito", "man123");
        realizaVenda(100.00, "Dinheiro", "man123");
    }

    public void realizaVenda(double valor, String formaPagamento, String matricula) {
        Venda venda = new Venda(valor, formaPagamento, matricula);
        vendas.add(venda);
        System.out.println("Venda realizada com sucesso!");
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public static Vendas getInstance() {
        if (instance == null) {
            instance = new Vendas();
        }
        return instance;
    }
}
