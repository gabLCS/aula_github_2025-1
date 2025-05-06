import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static int proximoNumero = 1;

    private int numero;
    private double saldo;
    private List<String> transacoes;
    private Cliente titular;

    public Conta(Cliente titular) {
        this.numero = proximoNumero++;
        this.titular = titular;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
        transacoes.add("Conta criada para " + titular.getNome());
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add("Saque de R$" + valor);
            return true;
        }
        return false;
    }

    public void gerarRelatorio() {
        System.out.println("=== Relatório da Conta " + numero + " ===");
        for (String t : transacoes) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$" + saldo);
    }

    public Cliente getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }
}
