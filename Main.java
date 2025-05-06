import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		boolean var = false;
		while(!var){
        Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
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
                        System.out.print("Informe o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Informe o CPF do cliente: ");
                        String cpf = scanner.nextLine();
                        Cliente novoCliente = new Cliente(nome, cpf);
                        clientes.add(novoCliente);
                        System.out.println("Cliente cadastrado com sucesso: " + novoCliente);
                        break;
                    case 2: // Sair
                        sair = true;
                        break;
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
