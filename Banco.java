import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Conta abrirConta(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                Conta conta = new Conta(c);
                contas.add(conta);
                System.out.println("Conta aberta com sucesso para " + c.getNome());
                return conta;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Conta encontrarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}
