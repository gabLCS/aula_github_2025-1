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

// Getters
public double getSaldo() {
    return saldo;
}

public Cliente getTitular() {
    return titular;
}

public String getNumeroConta() {
    return numeroConta;
}

@Override
public String toString() {
    return "Conta " + numeroConta + " - " + titular + " | Saldo: R$" + saldo;
}