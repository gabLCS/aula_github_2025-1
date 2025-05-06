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

    public boolean realizarSaque(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            System.out.println("Novo saldo: R$" + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
            System.out.println("Saldo atual: R$" + saldo);
            return false;
        }
    }

    public void realizarDeposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        System.out.println("Novo saldo: R$" + saldo);
    }

    // Getters
    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Conta " + numero + " - " + titular + " | Saldo: R$" + saldo;
    }
}
