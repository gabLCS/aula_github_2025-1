import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
            int opcao = mainMenu.getSelection();

            switch (opcao) {
                case 1:
                    menuConta(scanner);
                    break;
                case 2:
                    menuCliente(scanner);
                    break;
                case 3:
                    menuOperacoes(scanner);
                    break;
                case 4:
                    sair = true;
                    break;
            }
        }

        System.out.println("Fim do programa.");
    }

    private static void menuConta(Scanner scanner) {
        Menu contaMenu = new Menu("Menu da Conta", Arrays.asList(
                "Abrir Conta",
                "Voltar"
        ));
        int opcao = contaMenu.getSelection();
        if (opcao == 1) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();
            banco.abrirConta(cpf);
        }
    }

    private static void menuCliente(Scanner scanner) {
        Menu clienteMenu = new Menu("Menu do Cliente", Arrays.asList(
                "Cadastrar Cliente",
                "Voltar"
        ));
        int opcao = clienteMenu.getSelection();
        if (opcao == 1) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            banco.cadastrarCliente(nome, cpf);
        }
    }

    private static void menuOperacoes(Scanner scanner) {
        if (banco.getContas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("Contas disponíveis:");
        for (Conta c : banco.getContas()) {
            System.out.println("Conta " + c.getNumero() + " - Titular: " + c.getTitular().getNome());
        }

        System.out.print("Informe o número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        Conta conta = banco.encontrarContaPorNumero(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        boolean sair = false;
        while (!sair) {
            Menu operacoesMenu = new Menu("Menu de Operações", Arrays.asList(
                    "Realizar Saque",
                    "Gerar Relatório de Transações",
                    "Voltar"
            ));
            int selecao = operacoesMenu.getSelection();
            switch (selecao) {
                case 1:
                    System.out.print("Informe o valor do saque: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    if (conta.sacar(valor)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saque inválido ou saldo insuficiente.");
                    }
                    break;
                case 2:
                    conta.gerarRelatorio();
                    break;
                case 3:
                    sair = true;
                    break;
            }
        }
    }
}
