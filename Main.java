import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Banco banco = new Banco();
		boolean var = false;

		Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		while(!var){ 
        ArrayList<Conta> contas = new ArrayList<>();
		while(!var){
        int opcao = mainMenu.getSelection();
        System.out.println("Opcao " + opcao + " foi selecionada");
        if (opcao == 2) { // Suponha que "Cliente" é a opção 2
            Scanner scanner = new Scanner(System.in);
            ArrayList<Cliente> clientes = new ArrayList<>();
            boolean sair = false;

            while (!sair) {
                Menu clienteMenu = new Menu("Menu do Cliente", Arrays.asList(
                        "Cadastrar Cliente",
                        "Sair"
                ));
                int selecao = clienteMenu.getSelection();
                switch (selecao) {
                    case 1: // Cadastrar Cliente
					System.out.print("Nome: ");
					String nome = scanner.nextLine();
					System.out.print("CPF: ");
					String cpf = scanner.nextLine();
					banco.cadastrarCliente(nome, cpf);
                        break;
                    case 2: // Sair
                        sair = true;
                        break;
                        
                    case 3: // Realizar saque
                        boolean sairOperacoes = false;
                        while (!sairOperacoes) {
                            Menu operacoesMenu = new Menu("Menu de Operações", Arrays.asList(
                                    "Realizar Saque", // Nova opção
                                    "Sair"
                            ));
                            int selecao = operacoesMenu.getSelection();
                            switch (selecao) {
                                case 1: // Realizar Saque
                                    if (contas.isEmpty()) {
                                        System.out.println("Nenhuma conta cadastrada!");
                                        break;
                                    }
                                    System.out.println("\nContas disponíveis:");
                                    for (int i = 0; i < contas.size(); i++) {
                                        System.out.println((i + 1) + ". " + contas.get(i));
                                    }
                                    System.out.print("Escolha a conta (número): ");
                                    int numConta = Integer.parseInt(scanner.nextLine()) - 1;
                                    
                                    System.out.print("Valor do saque: R$");
                                    double valor = Double.parseDouble(scanner.nextLine());
                                    
                                    contas.get(numConta).realizarSaque(valor); // Chama o método de saque
                                    break;
                                case 2: // Sair
                                    sairOperacoes = true;
                                    break;
                            }
                        }
                }
            }
        }
		if(opcao == 1){
			Scanner scanner = new Scanner(System.in);
            ArrayList<Cliente> contas = new ArrayList<>();
            boolean sair = false;
			while (!sair) {
				Menu contaMenu = new Menu("Menu da Conta", Arrays.asList(
                "Abrir Conta",
                "Voltar"));
				 int selecao = contaMenu.getSelection();
				 if (selecao == 1) {
					System.out.print("Digite o CPF do cliente: ");
					String cpf = scanner.nextLine();
					banco.abrirConta(cpf);
				}
				if(selecao == 2){
					sair = true;
				}
			}

		}
		
		if(opcao == 4){
			var = true;

		}
	}

        System.out.println("Fim");
    }
}
